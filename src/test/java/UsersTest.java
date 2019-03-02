import com.mirr.tickets.users.UserDto;
import com.mirr.tickets.users.UserService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UsersTest {


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
        testUserDto.setEmail("kseniamirr@gmail.com");
        return testUserDto;
    }


}
