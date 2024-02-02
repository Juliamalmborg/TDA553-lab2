import java.awt.*;

public class Scania extends Truck {
    private final static int maxAngle = 70;
    private RampWithAngle ramp;

    public Scania(){
        super(2, Color.blue, 200, "Scania");
        this.ramp = new RampWithAngle(maxAngle);
    }

    public boolean getIsRampOn() {
        return ramp.getIsRampOn();
    }

    public int getRampAngle() {
        return ramp.getRampAngle();
    }

    public static int getMaxAngle() {
        return maxAngle;
    }

    @Override
    protected int getSize(){
        return 3;} //large
    }
}
