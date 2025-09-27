import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicOpsTest {

    private BasicOps basicOps;
    private static final double DELTA = 1e-9;

    @BeforeEach
    void setUp() {
        basicOps = new BasicOps();
    }

    @Test
    void testAdd() {
        assertEquals(30.0, basicOps.add(10, 20), DELTA, "10 + 20 should be 30.0");
        assertEquals(-10.0, basicOps.add(10, -20), DELTA, "10 + (-20) should be -10.0");
        assertEquals(0.0, basicOps.add(0, 0), DELTA, "0 + 0 should be 0.0");
    }

    @Test
    void testSubstract() {
        assertEquals(-10.0, basicOps.substract(10, 20), DELTA, "10 - 20 should be -10.0");
        assertEquals(30.0, basicOps.substract(10, -20), DELTA, "10 - (-20) should be 30.0");
        assertEquals(0.0, basicOps.substract(0, 0), DELTA, "0 - 0 should be 0.0");
    }

    @Test
    void testMul() {
        assertEquals(200.0, basicOps.mul(10, 20), DELTA, "10 * 20 should be 200.0");
        assertEquals(-200.0, basicOps.mul(10, -20), DELTA, "10 * (-20) should be -200.0");
        assertEquals(0.0, basicOps.mul(10, 0), DELTA, "10 * 0 should be 0.0");
    }

    @Test
    void testDiv() {
        assertEquals(0.5, basicOps.div(10, 20), DELTA, "10 / 20 should be 0.5");
        assertEquals(-0.5, basicOps.div(10, -20), DELTA, "10 / (-20) should be -0.5");
    }

    @Test
    void testDivByZero() {
        assertEquals(Double.POSITIVE_INFINITY, basicOps.div(10, 0), DELTA, "Division by zero should return Infinity");
    }
}