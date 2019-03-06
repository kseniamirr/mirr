import com.mirr.tickets.annotation.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mirr.tickets.annotation.DBProperties;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ConfigTest {

@Autowired
private DBProperties dbProperties;

    @Test
    public void testConfig() {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, DBProperties.class);) {
            DBProperties dbProperties = context.getBean(DBProperties.class);

        }
    }

}
