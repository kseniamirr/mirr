import com.mirr.tickets.annotation.AppConfig;
import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.auditoriums.AuditoriumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AuditoriumsMockBeanAnnotationTest {

    @Autowired
    AuditoriumService auditoriumService;

    @Test
    public void getAllTest() {
        Set<Auditorium> auditoriumSet = auditoriumService.getAll();
        auditoriumSet.stream().forEach(auditoriumDto -> System.out.println("auditorium: " + auditoriumDto));
        assertTrue("size is not correct", auditoriumSet.size() > 1);

    }

}
