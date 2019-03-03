import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.EventDto;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EventsTests {

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
        eventDto.getId();
       assertEquals("Id is not correct", 0355, eventDto);

    }

    private EventDto initEvent() {
        EventDto eventDto = new EventDto();
        eventDto.setId(0355);
        return eventDto;
    }

    @Test
    public void getAllEvents() {

        EventDto event = initEvent();
        eventService.save(event);
        List<EventDto> eventDtoList = eventService.getAll();
        assertNotEquals("Event collection is empty", eventDtoList.size(), 0);

    }

}
