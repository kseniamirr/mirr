import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.EventDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-Spring.xml"})
public class EventsTests {

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
        List<EventDto> eventDtoList = eventService.getAllEvents();
        assertNotEquals("Event collection is empty", 0, eventDtoList.size());

    }

}
