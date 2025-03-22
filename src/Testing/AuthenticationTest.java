package Testing;
import Authentication.Authentication;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationTest {
    private Authentication auth=new Authentication();

    @Test
    void testLogin() {
        auth.register("User", "User");
        assertTrue(auth.login("User", "User"));
    }
}
