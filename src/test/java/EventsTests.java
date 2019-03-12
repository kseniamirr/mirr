import com.mirr.tickets.annotation.BaseConfig;
import com.mirr.tickets.aspect.CounterAspect;
import com.mirr.tickets.dao.EventDao;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.Seance;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BaseConfig.class, loader = AnnotationConfigContextLoader.class)
public class EventsTests {

    private final String AUDITORIUM_NAME = "White";

    @Autowired
    EventService eventService;

    @Autowired
    CounterAspect counterEventAspect;

    private Event event1;

    private Event event2;

    @Before
    public void prepareTestData() {
        event1 = new Event();
        event1.setEventName("Blue");
        event1 = eventService.save(event1);

        event2 = new Event();
        event2.setEventName("Green");
        event2 = eventService.save(event2);
    }



    @Test
    public void getNameTest() {
        Optional<Event> testEvent = eventService.getEventByName(event1.getEventName());
        assertTrue("Event not found by eventName", testEvent.isPresent() && testEvent.get().getEventName().equals(event1.getEventName()));

        testEvent = eventService.getEventByName(event2.getEventName());
        assertTrue("Event not found by eventName", testEvent.isPresent() && testEvent.get().getEventName().equals(event2.getEventName()));

        testEvent = eventService.getEventByName(event1.getEventName());
        assertTrue("Event not found by eventName", testEvent.isPresent() && testEvent.get().getEventName().equals(event1.getEventName()));

        Optional<Integer> counter = counterEventAspect.getCounterByClass(EventDao.class);
        assertTrue("Counter aspect was not called", counter.isPresent() && counter.get() > 0);
        System.out.println("Counter is: " + counter.get().intValue());

    }

    @Test
    public void getEventIdTest() {
        Optional<Event> testEvent = eventService.getById(event1.getEventId());
        assertTrue("Event not found by userId", testEvent.isPresent() && testEvent.get().getEventId() == event1.getEventId());
    }

    static Event initEvent() {
        Event event = new Event();
        event.setEventId(0355);
        event.setEventName("Vice");
        event.setBasePrice(15);
        return event;
    }

    @Test
    public void getAllEvents() {

        Event event = initEvent();
        eventService.save(event);
        Set<Event> eventList = eventService.getAllEvents();
        assertNotEquals("Event collection is empty", 0, eventList.size());
    }


    @Test
    public void testSaveSeance() {
        Event event = EventsTests.initEvent();
        eventService.save(event);

        LocalDateTime airDateTime = LocalDateTime.of(2019, 03, 07, 20, 00);

        Seance seance = eventService.saveSeance(event.getEventName(), AUDITORIUM_NAME, airDateTime);

        assertNotEquals("seance userId is not filled", 0, seance.getSeanceId());
        assertEquals("seance auditorium is not correct", AUDITORIUM_NAME, seance.getAuditoriumName());
        assertEquals("seance air date/time is not correct", airDateTime, seance.getAirDateTime());
    }

}
