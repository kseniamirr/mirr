import com.mirr.tickets.annotation.BaseConfig;
import com.mirr.tickets.annotation.DBProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BaseConfig.class)
public class ConfigTest {

    @Test
    public void testConfig() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);
        DBProperties dbProperties = context.getBean(DBProperties.class);
        System.out.println("dbProperties.getAuditoriumNames: " + dbProperties.getAuditoriumNames());
        System.out.println("dbProperties.getAuditoriumSeatsNumber: " + dbProperties.getAuditoriumSeatsNumber());
        System.out.println("dbProperties.getAuditoriumVIPSeats: " + dbProperties.getAuditoriumVIPSeats());

        assertNotNull("property auditoriumNames is not initialized ", dbProperties.getAuditoriumNames());
        assertNotNull("property auditoriumSeatsNumber is not initialized ", dbProperties.getAuditoriumSeatsNumber());
        assertNotNull("property auditoriumVIPSeats is not initialized ", dbProperties.getAuditoriumVIPSeats());

    }

}
