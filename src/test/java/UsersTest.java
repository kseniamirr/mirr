import com.mirr.tickets.users.UserDto;
import com.mirr.tickets.users.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-Spring.xml"})
//"/test-Spring.xml"
public class UsersTest {


    @Autowired
    UserService userService;

    @Test
    public void testSaveUser() {
        UserDto userDto = initUser();
        UserDto userDto1 = userService.save(userDto);
        UserDto testResult = userService.getUserById(userDto1.getId());
        assertNotNull(testResult);
        assertEquals("Email is not stored correctly", userDto.getEmail(), testResult.getEmail());
    }

    private UserDto initUser() {
        UserDto testUserDto = new UserDto();
        testUserDto.setEmail("San");
        return testUserDto;
    }
}
