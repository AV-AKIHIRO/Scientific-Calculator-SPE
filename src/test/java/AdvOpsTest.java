import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvOpsTest {

    private AdvOps advOps;
    private static final double DELTA = 1e-9; // A small tolerance for floating-point comparisons

    @BeforeEach
    void setUp() {
        advOps = new AdvOps();
    }

    @Test
    void testSquareRoot() {
        assertEquals(2.0, advOps.sqrt(4.0), DELTA, "Square root of 4 should be 2");
        assertEquals(0.0, advOps.sqrt(0.0), DELTA, "Square root of 0 should be 0");
        assertEquals(1.414213562, advOps.sqrt(2.0), DELTA, "Square root of 2 is not correct");
    }

    @Test
    void testFactorial() {
        assertEquals(1, advOps.factorial(0), "Factorial of 0 should be 1");
        assertEquals(1, advOps.factorial(1), "Factorial of 1 should be 1");
        assertEquals(120, advOps.factorial(5), "Factorial of 5 should be 120");
    }

    @Test
    void testNaturalLog() {
        assertEquals(0.0, advOps.ln(1.0), DELTA, "Natural log of 1 should be 0");
        assertEquals(1.0, advOps.ln(Math.E), DELTA, "Natural log of e should be 1");
    }

    @Test
    void testPower() {
        assertEquals(8.0, advOps.pow(2.0, 3.0), DELTA, "2^3 should be 8");
        assertEquals(1.0, advOps.pow(10.0, 0.0), DELTA, "10^0 should be 1");
        assertEquals(0.25, advOps.pow(2.0, -2.0), DELTA, "2^-2 should be 0.25");
    }
}