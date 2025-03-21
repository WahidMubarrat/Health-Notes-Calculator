package Testing;
import MainProgramme.Authentication;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;
import java.util.*;
public class AuthenticationTest {
    private Authentication auth=new Authentication();

    @Test
    void testLogin() {
        auth.register("User", "User");
        assertTrue(auth.login("User", "User"));
    }
}
