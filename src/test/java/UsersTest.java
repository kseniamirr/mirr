import com.mirr.tickets.annotation.BaseConfig;
import com.mirr.tickets.users.User;
import com.mirr.tickets.users.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BaseConfig.class})
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
        Optional<User> testResult = userService.getUserById(userToVerify.getUserId());
        assertTrue("Test user is not found", testResult.isPresent());
        assertEquals("Email is not stored correctly", userToVerify.getEmail(), testResult.get().getEmail());
        /*
        assertNotNull(testResult);
        assertEquals("Email is not stored correctly", userToVerify.getEmail(), testResult.getEmail());
        */
        userService.remove(userToVerify.getUserId());
        Optional<User> testResult2 = userService.getUserById(userToVerify.getUserId());
        assertTrue("Remove method didn't delete user", ! testResult2.isPresent());
    }

    @Test
    public void testGetAll() {
        Set<User> dtoList = userService.getAll();
        assertTrue("size is not correct", dtoList.size() > 1);
    }

    @Test
    public void testGetByEmail() {
        Optional<User> testUser = userService.getUserByEmail(testUser1.getEmail());
        assertTrue("user is not found or found incorrect", testUser.isPresent() && testUser1.getEmail().equals(testUser.get().getEmail()));
    }

    @Test
    public void testGetByEmail2() {
        Optional<User> testUser = userService.getUserByEmail(testUser2.getEmail());
        assertTrue("user is not found or found incorrect", testUser.isPresent() && testUser2.getEmail().equals(testUser.get().getEmail()));
    }


}
