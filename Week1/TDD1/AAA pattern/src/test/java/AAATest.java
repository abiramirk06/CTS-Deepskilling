import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AAATest {
    // Test Fixture
    Calculator calculator;
    @BeforeEach
    void setUp() {
        System.out.println("Setting up...");
        calculator = new Calculator();
    }
    @Test
    void testAddition() {
        // Arrange
        int a = 5;
        int b = 3;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(8, result);
    }
    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }
}