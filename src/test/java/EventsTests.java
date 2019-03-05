import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.SeanceDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-Spring.xml"})
public class EventsTests {

    private final String AUDITORIUM_NAME = "White";

    @Autowired
    EventService eventService;

    @Test
    public void getNameTest() {
        Event event = initName();
        event.getName();
        assertEquals("The name is not correct", "Blue", event.getName());

    }

    private Event initName() {
        Event event = new Event();
        event.setName("Blue");
        return event;
    }

    @Test
    public void getEventIdTest() {
        Event event = initEvent();
        eventService.save(event);
        Event testEvent = eventService.getById(event.getId());
       assertEquals("Id is not correct", event.getId(), testEvent.getId());

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
        List<Event> eventList = eventService.getAllEvents();
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
