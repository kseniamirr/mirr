import com.mirr.tickets.annotation.AppConfig;
import com.mirr.tickets.booking.BookingService;
import com.mirr.tickets.events.EventService;
import com.mirr.tickets.ticket.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class BookingTest {

    private final String AUDITORIUM_NAME = "White";

    @Autowired
    BookingService bookingService;


//    @BeforeClass
//    public void initData() {
//        Event eventDto = EventsTests.initEvent();
//        Event eventDtoAdded = eventService.save(eventDto);
//
//        LocalDateTime airDateTime = LocalDateTime.of(2019, 03, 07, 20, 00);
//
//        SeanceDto seanceDto = eventService.saveSeance(eventDto.getName(), AUDITORIUM_NAME, airDateTime);
//
//        assertNotEquals("seance id is not filled", 0, seanceDto.getSeanceId());
//        assertEquals("seance auditorium is not correct", AUDITORIUM_NAME, seanceDto.getAuditoriumName());
//        assertEquals("seance air date/time is not correct", airDateTime, seanceDto.getAirDateTime());
//    }

    @Test
    public void getTicketsByPrice() {
        }





}
