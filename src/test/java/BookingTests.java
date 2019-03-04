import com.mirr.tickets.booking.BookingService;
import com.mirr.tickets.booking.BookingServiceImpl;
import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.ticket.TicketDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-Spring.xml"})

public class BookingTests {

    @Autowired
    BookingService bookingService;

//    @Test
//    public void getTicketsPrice() {
//
//        EventDto eventDto = new EventDto();
//        List<TicketDto> ticketDtoList = bookingService.getTicketsPrice(eventDto, LocalDateTime.now());
//        assertEquals(0, ticketDtoList.size());
//    }

//    @Test
//    public void getAllPurchasedTicketsForEvent() {
//
//        EventDto eventDto = new EventDto();
//        List<TicketDto> ticketDtoList = bookingService.getPurchasedTicketsForEvent(eventDto, LocalDateTime.now());
//        assertEquals(0, ticketDtoList.size());
//    }
}
