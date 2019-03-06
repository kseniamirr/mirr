import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.auditoriums.AuditoriumService;
import com.mirr.tickets.auditoriums.AuditoriumServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)

public class AuditoriumsMockBeanAnnotationTest {



    @Bean
    public AuditoriumService auditoriumService() {
        return new AuditoriumServiceImpl();
    }

    @Autowired
    AuditoriumService auditoriumService;



    @Test
    public void getAllTest() {
        Set<Auditorium> auditoriumSet = auditoriumService.getAll();
        auditoriumSet.stream().forEach(auditoriumDto -> System.out.println("auditorium: " + auditoriumDto));
        assertTrue("size is not correct", auditoriumSet.size() > 1);

    }

}
