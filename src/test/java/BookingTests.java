import com.mirr.tickets.booking.BookingService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-Spring.xml"})

public class BookingTests {

    @Autowired
    BookingService bookingService;

//    @Test
//    public void getTicketsPrice() {
//
//        Event eventDto = new Event();
//        List<Ticket> ticketDtoList = bookingService.getTicketsPrice(eventDto, LocalDateTime.now());
//        assertEquals(0, ticketDtoList.size());
//    }

//    @Test
//    public void getAllPurchasedTicketsForEvent() {
//
//        Event eventDto = new Event();
//        List<Ticket> ticketDtoList = bookingService.getPurchasedTicketsForEvent(eventDto, LocalDateTime.now());
//        assertEquals(0, ticketDtoList.size());
//    }
}
