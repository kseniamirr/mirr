import com.mirr.tickets.events.EventDto;
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
        EventDto eventDto = initName();
        eventDto.getName();
        assertEquals("The name is not correct", "Blue", eventDto.getName());

    }

    private EventDto initName() {
        EventDto eventDto = new EventDto();
        eventDto.setName("Blue");
        return eventDto;
    }

    @Test
    public void getEventIdTest() {
        EventDto eventDto = initEvent();
        eventService.save(eventDto);
        EventDto testEvent = eventService.getById(eventDto.getId());
       assertEquals("Id is not correct", eventDto.getId(), testEvent.getId());

    }

    static EventDto initEvent() {
        EventDto eventDto = new EventDto();
        eventDto.setId(0355);
        eventDto.setName("Vice");
        eventDto.setBasePrice(15);
        return eventDto;
    }

    @Test
    public void getAllEvents() {

        EventDto event = initEvent();
        eventService.save(event);
        List<EventDto> eventDtoList = eventService.getAllEvents();
        assertNotEquals("Event collection is empty", 0, eventDtoList.size());
    }


    @Test
    public void testSaveSeance() {
        EventDto eventDto = EventsTests.initEvent();
        EventDto eventDtoAdded = eventService.save(eventDto);

        LocalDateTime airDateTime = LocalDateTime.of(2019, 03, 07, 20, 00);

        SeanceDto seanceDto = eventService.saveSeance(eventDto.getName(), AUDITORIUM_NAME, airDateTime);

        assertNotEquals("seance id is not filled", 0, seanceDto.getSeanceId());
        assertEquals("seance auditorium is not correct", AUDITORIUM_NAME, seanceDto.getAuditoriumName());
        assertEquals("seance air date/time is not correct", airDateTime, seanceDto.getAirDateTime());
    }

}
