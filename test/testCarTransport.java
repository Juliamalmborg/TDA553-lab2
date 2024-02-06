import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
public class testCarTransport {
    private CarTransport ct;

    @Before
    public void create_cartransport() {ct = new CarTransport(2, Color.black, 500, "Mercedes");}

    @Test
    public void testSamePosLoad(){
        Vehicle car = new Saab95();
        car.setXpos(ct.getXpos());
        car.setYpos(ct.getYpos());
        ct.lowerRamp();
        ct.loadCar(car);
        ct.raiseRamp();
        assertEquals(ct.getXpos(), car.getXpos(), 0);
        assertEquals(ct.getYpos(), car.getYpos(), 0);
    }
    @Test
    public void testloadedcars(){
        Vehicle volvo = new Volvo240();
        ct.lowerRamp();
        ct.loadCar(volvo);
        ct.loadCar(volvo);
        ct.unloadCar(volvo);
        assertEquals(1,ct.getnrCarsOnRamp(), 0);
    }

    @Test
    public void testErrorLowerRamp(){
        ct.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            ct.lowerRamp();
        });
        assertEquals("Truck cannot lower ramp while moving.", e.getMessage());
    }

    @Test
    public void testErrorRaiseRamp(){
        ct.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            ct.raiseRamp();
        });
        assertEquals("Truck cannot raise ramp while moving.", e.getMessage());
    }

}
