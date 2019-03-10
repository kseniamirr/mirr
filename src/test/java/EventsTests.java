import com.mirr.tickets.annotation.AppConfig;
import com.mirr.tickets.aspect.EventsAspect;
import com.mirr.tickets.dao.EventDao;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.SeanceDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class EventsTests {

    private final String AUDITORIUM_NAME = "White";

    @Autowired
    EventService eventService;

    @Autowired
    EventsAspect eventsAspect;

    private Event event1;

    private Event event2;

    @Before
    public void prepareTestData() {
        event1 = new Event();
        event1.setName("Blue");
        event1 = eventService.save(event1);

        event2 = new Event();
        event2.setName("Green");
        event2 = eventService.save(event2);
    }



    @Test
    public void getNameTest() {
        Optional<Event> testEvent = eventService.getEventByName(event1.getName());
        assertTrue("Event not found by name", testEvent.isPresent() && testEvent.get().getName().equals(event1.getName()));

        testEvent = eventService.getEventByName(event2.getName());
        assertTrue("Event not found by name", testEvent.isPresent() && testEvent.get().getName().equals(event2.getName()));

        testEvent = eventService.getEventByName(event1.getName());
        assertTrue("Event not found by name", testEvent.isPresent() && testEvent.get().getName().equals(event1.getName()));

        Optional<Integer> counter = eventsAspect.getCounterByClass(EventDao.class);
        assertTrue("Counter aspect was not called", counter.isPresent() && counter.get() > 0);
        System.out.println("Counter is: " + counter.get().intValue());

    }

    @Test
    public void getEventIdTest() {
        Optional<Event> testEvent = eventService.getById(event1.getId());
        assertTrue("Event not found by id", testEvent.isPresent() && testEvent.get().getId() == event1.getId());
    }

    static Event initEvent() {
        Event event = new Event();
        event.setId(0355);
        event.setName("Vice");
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
        Event eventAdded = eventService.save(event);

        LocalDateTime airDateTime = LocalDateTime.of(2019, 03, 07, 20, 00);

        SeanceDto seanceDto = eventService.saveSeance(event.getName(), AUDITORIUM_NAME, airDateTime);

        assertNotEquals("seance id is not filled", 0, seanceDto.getSeanceId());
        assertEquals("seance auditorium is not correct", AUDITORIUM_NAME, seanceDto.getAuditoriumName());
        assertEquals("seance air date/time is not correct", airDateTime, seanceDto.getAirDateTime());
    }

}
