import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AssertionsTest {
    @Test
    void testAssertions() {
        assertEquals(5, 2 + 3);
        assertNotEquals(10, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        String name = null;
        assertNull(name);
        Object obj = new Object();
        assertNotNull(obj);
    }
}
