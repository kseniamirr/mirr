import com.mirr.tickets.annotation.AppConfig;
import com.mirr.tickets.booking.BookingService;
import com.mirr.tickets.discount.DiscountStrategy;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventService;
import com.mirr.tickets.users.User;
import com.mirr.tickets.users.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class DiscountTests {


    @Autowired
    DiscountStrategy discountStrategy;

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    @Autowired
    BookingService bookingService;
//
//    @Test
//    public int getBirthdayDiscount(Event event, User user, LocalDateTime dateTime, int numberOfTickets)
//        // discountStrategy.getBirthdayDiscount(user, event,dateTime,numberOfTickets);
//        //assertThat()
//


}
