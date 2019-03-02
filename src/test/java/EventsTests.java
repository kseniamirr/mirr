import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.EventServiceDto;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EventsTests {

    EventService eventService;

    @Test
    public void getPriceEventsTest() {
        EventServiceDto eventServiceDto = initPriceForTicket();
        eventServiceDto.getPriceForTicket();
        assertEquals("The price is not correct", 200, eventServiceDto.getPriceForTicket());

    }

    private EventServiceDto initPriceForTicket() {
        EventServiceDto eventServiceDto = new EventServiceDto();
        eventServiceDto.setPriceForTicket(150);
        return eventServiceDto;
    }

    @Test
    public void getEventIdTest() {
        EventServiceDto eventServiceDto = initEvent();
        eventServiceDto.getId();
       assertEquals("Id is not correct", 0355, eventServiceDto);

    }

    private EventServiceDto initEvent() {
        EventServiceDto eventServiceDto = new EventServiceDto();
        eventServiceDto.setId(0355);
        return eventServiceDto;
    }

    @Test
    public void getAllEvents() {

        EventServiceDto event = initEvent();
        eventService.save(event);
        List<EventServiceDto> eventDtoList = eventService.getAll();
        assertNotEquals("Event collection is empty", eventDtoList.size(), 0);

    }

}
