import com.mirr.tickets.users.UserDto;
import com.mirr.tickets.users.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-Spring.xml"})
public class UsersTest {


    @Autowired
    UserService userService;

    private UserDto testUserDto1;

    private UserDto testUserDto2;


    @Before
    public void prepareTestData() {
        testUserDto1 = new UserDto();
        testUserDto1.setEmail("user1");
        testUserDto1 = userService.save(testUserDto1);

        testUserDto2 = new UserDto();
        testUserDto2.setEmail("user2");
        testUserDto2 = userService.save(testUserDto2);
    }


    @Test
    public void testSaveUser() {
        UserDto userDto = new UserDto();
        userDto.setEmail("San");
        UserDto userToVerify = userService.save(userDto);
        UserDto testResult = userService.getUserById(userToVerify.getId());
        assertNotNull(testResult);
        assertEquals("Email is not stored correctly", userToVerify.getEmail(), testResult.getEmail());
        userService.remove(userToVerify.getId());
        UserDto testResult2 = userService.getUserById(userToVerify.getId());
        assertNull("Remove method didn't remove user", testResult2);
    }

    @Test
    public void testGetAll() {
        List<UserDto> dtoList = userService.getAll();
        assertTrue("size is not correct", dtoList.size() > 1);
    }

    @Test
    public void testGetByEmail() {
        UserDto testUser = userService.getUserByEmail(testUserDto1.getEmail());
        assertNotNull(testUser);
        assertEquals("Found wrong user", testUserDto1.getEmail(), testUser.getEmail());
    }

    @Test
    public void testGetByEmail2() {
        UserDto testUser = userService.getUserByEmail(testUserDto2.getEmail());
        assertNotNull(testUser);
        assertEquals("Found wrong user", testUserDto2.getEmail(), testUser.getEmail());
    }


}
