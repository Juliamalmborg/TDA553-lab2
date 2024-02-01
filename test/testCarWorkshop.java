import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class testCarWorkshop {
    private CarWorkshop cw;

    @Before
    public void create_workshop() {cw = new CarWorkshop(2);}

    @Test
    public void testloadedcars(){
        SaabCarWorkshop sw = new SaabCarWorkshop(2);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        sw.LoadCar(saab);
        //sw.LoadCar(volvo); //Får compile time error pga Saab95 workshop
    }

    @Test
    public void testloadmaxworkshop(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        cw.loadCar(saab);
        cw.loadCar(volvo);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            cw.loadCar(volvo);
        });
        assertEquals("Cannot load another car to Workshop.",e.getMessage());
    }


}
