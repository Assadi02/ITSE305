import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRegistrationSystem {

    private RegistrationSystem registrationSystem;

    @Before
    public void setUp() {
        registrationSystem = new RegistrationSystem();
    }

    @Test
    public void testRegisterUser() {
        assertTrue(registrationSystem.registerUser("testUser", "password"));
        assertFalse(registrationSystem.registerUser("testUser", "password")); // Attempt to register the same user again
    }

    @Test
    public void testValidateUser() {
        String username = "testUser";
        String password = "password";

        assertFalse(registrationSystem.validateUser(username, password)); // User not registered yet

        registrationSystem.registerUser(username, password);

        assertTrue(registrationSystem.validateUser(username, password));
        assertFalse(registrationSystem.validateUser(username, "wrongPassword"));
    }

    @Test
    public void testUserDatabaseSize() {
        assertEquals(0, registrationSystem.getUserDatabase().size());

        registrationSystem.registerUser("user1", "pass1");
        registrationSystem.registerUser("user2", "pass2");

        assertEquals(2, registrationSystem.getUserDatabase().size());
    }
}
