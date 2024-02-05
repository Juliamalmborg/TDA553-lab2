import java.awt.*;

public class Scania extends Truck {
    private static int maxAngle = 70;
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

    public void setRampAngle(int maxAngle) {ramp.setRamp(maxAngle);}

    @Override
    protected int getSize(){
        return 3;} //large
    }

