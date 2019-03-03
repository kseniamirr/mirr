import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.List;

@Configuration
@PropertySource(value="C:/Users/User/Desktop/SpringCore/src/test/resources/vipSeats.properties")
public class AuditoriumConfigTest {

    @Value("#{'${vipSeats.name}'.split(',')}")
    private List<String> vipSeats;

       //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigVipSeats() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}


