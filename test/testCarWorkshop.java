import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class testCarWorkshop {
    private CarWorkshop cw;

    @Before
    public void create_workshop() {cw = new CarWorkshop(5);}

    @Test
    public void testloadedcars(){
        Vehicle saab = new Saab95();
        Vehicle volvo = new Volvo240();
        cw.LoadCar(saab);
        cw.UnloadCar();
    }
}
