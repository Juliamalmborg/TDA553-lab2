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

    public double getRampAngle() {
        return ramp.getRampAngle();
    }

    public void raiseRamp(double angle) {
        if (getCurrentSpeed() == 0){
            ramp.raiseRamp(angle);}
        else
            throw new IllegalArgumentException("cannot raise ramp while moving");
    }

    public void lowerRamp(double angle) {
        if (getCurrentSpeed() == 0){
        ramp.lowerRamp(angle);}
        else
            throw new IllegalArgumentException("cannot lower ramp while moving");
    }

    public double getMaxAngle(){
        return ramp.getMaxAngle();
    }

    }

