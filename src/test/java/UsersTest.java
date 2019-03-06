import com.mirr.tickets.annotation.AppConfig;
import com.mirr.tickets.users.User;
import com.mirr.tickets.users.UserService;
import com.mirr.tickets.users.UserServiceImpl;
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
@ContextConfiguration(classes = {AppConfig.class})
public class UsersTest {


    @Autowired
    UserServiceImpl userService;

    private User testUser1;

    private User testUser2;


    @Before
    public void prepareTestData() {
        testUser1 = new User();
        testUser1.setEmail("user1");
        testUser1 = userService.save(testUser1);

        testUser2 = new User();
        testUser2.setEmail("user2");
        testUser2 = userService.save(testUser2);
    }


    @Test
    public void testSaveUser() {
        User user = new User();
        user.setEmail("San");
        User userToVerify = userService.save(user);
        User testResult = userService.getUserById(userToVerify.getId());
        assertNotNull(testResult);
        assertEquals("Email is not stored correctly", userToVerify.getEmail(), testResult.getEmail());
        userService.remove(userToVerify.getId());
        User testResult2 = userService.getUserById(userToVerify.getId());
        assertNull("Remove method didn't remove user", testResult2);
    }

    @Test
    public void testGetAll() {
        List<User> dtoList = userService.getAll();
        assertTrue("size is not correct", dtoList.size() > 1);
    }

    @Test
    public void testGetByEmail() {
        User testUser = userService.getUserByEmail(testUser1.getEmail());
        assertNotNull(testUser);
        assertEquals("Found wrong user", testUser1.getEmail(), testUser.getEmail());
    }

    @Test
    public void testGetByEmail2() {
        User testUser = userService.getUserByEmail(testUser2.getEmail());
        assertNotNull(testUser);
        assertEquals("Found wrong user", testUser2.getEmail(), testUser.getEmail());
    }


}
