import com.mirr.tickets.auditoriums.AuditoriumDto;
import com.mirr.tickets.auditoriums.AuditoriumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-Spring.xml"})
public class AuditoriumTests {

    @Autowired
    AuditoriumService auditoriumService;

    @Test
    public void getAllTest() {
        Set<AuditoriumDto> auditoriumDtoSet = auditoriumService.getAll();
        auditoriumDtoSet.stream().forEach(auditoriumDto -> System.out.println("auditorium: " + auditoriumDto));
        assertTrue("size is not correct", auditoriumDtoSet.size() > 1);

    }

}
