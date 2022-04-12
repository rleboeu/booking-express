import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * @author Andrew Garcia
 */
public class UserTest {
    @Test
    public void testCreateUser() {
        String name = "Andy";
        String lName = "Al";
        int age = 19;
        String location = "";
        RegisteredUser usr = new RegisteredUser(name, lName, age, location);
        assertEquals(User.createAccoutn(name, lName, age), usr);
    }
}
