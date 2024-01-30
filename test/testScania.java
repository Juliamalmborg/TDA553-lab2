import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class testScania {
    private Scania scania;

    @Before
    public void create_cars() {
        scania = new Scania();
    }

    @Test // TODO denna funkar ej
    public void testLiftRamp() {
        scania.stopEngine();
        scania.liftRamp(20);
        assertEquals(20, scania.getAngle(), 0);
    }
}
