import com.mirr.tickets.annotation.AppConfig;

import com.mirr.tickets.discount.DiscountStrategy;
import com.mirr.tickets.events.Event;

import com.mirr.tickets.events.EventService;
import com.mirr.tickets.events.Seance;
import com.mirr.tickets.users.User;

import com.mirr.tickets.users.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class DiscountTests {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    DiscountStrategy discountStrategy;

    private Event event;

    private Event event2;

    private User user;

    private User user2;

    private Seance seance;


    @Before
    public void prepareTestData() {
        event = new Event();
        event.setName("Game og thrones");
        event = eventService.save(event);

        event2 = new Event();
        event2.setName("Born a star");
        event2 = eventService.save(event2);

        user = new User();
        user.setDateOfBirthday(LocalDate.of(1985, 03, 16));
        user.setFirsName("Lady");
        user.setLastName("Gaga");
        user = userService.save(user);

        user2 = new User();
        user2.setFirsName("Oksana");
        user2.setLastName("Abramova");
        user2 = userService.save(user2);

        seance = new Seance(1, "Blue", LocalDate.of(2019, 03, 11));
        seance.setSeanceId(1);
        seance.setAirDateTime(LocalDate.of(2019,03,11));
    }

    @Test
    public void getBirthdayDiscount() {
        discountStrategy.getBirthdayDiscount(user, event, seance, 10);
        //assertThat("Discount is not correct ", 5, 5  );
        }

}
