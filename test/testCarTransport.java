import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
public class testCarTransport {
    private CarTransport ct;

    @Before
    public void create_cars() {ct = new CarTransport(2, Color.black, 500, "Mercedes");}

    @Test
    public void testSamePosLoad(){
        Vehicle car = new Saab95();
        ct.lowerRamp();
        ct.LoadCar(car);
        ct.raiseRamp();
        assertEquals(ct.getXpos(), car.getXpos(), 0);
        assertEquals(ct.getYpos(), car.getYpos(), 0);
    }
    @Test
    public void testloadedcars(){
        Vehicle saab = new Saab95();
        Vehicle volvo = new Volvo240();
        ct.lowerRamp();
        ct.LoadCar(saab);
        ct.LoadCar(saab);
        ct.UnloadCar();
        ct.LoadCar(volvo);
        assertEquals(ct.getnrCarsOnRamp(), 2, 0);
    }

    @Test
    public void testErrorLowerRamp(){
        ct.startEngine();
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            ct.lowerRamp();
        });
        assertEquals("Truck cannot lower ramp while moving.", e.getMessage());
    }

    @Test
    public void testErrorRaiseRamp(){
        ct.startEngine();
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            ct.raiseRamp();
        });
        assertEquals("Truck cannot raise ramp while moving.", e.getMessage());
    }

}
