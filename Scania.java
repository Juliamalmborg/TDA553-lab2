import java.awt.*;
public class Scania extends Truck implements TruckPlatform{
    private boolean truckRamp; //har en ramp

    public Scania(){
        super(2, Color.blue, 200, "Scania");
        this.truckRamp = true;
    }

    private void incrementAngle(double angle) {
        setAngle(getAngle() + angle);
    }

    private void decrementAngle(double angle) {
        setAngle(getAngle() - angle);
    }
    @Override
    public void lowerRamp(double angle) { // sänka flaket för att kunna lasta på
        if (getCurrentSpeed() == 0 && angle + getAngle() < 70 && angle >= 0) {
            incrementAngle(angle);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or maximum angle is allowed to be 70 degrees.");
        }
        }
    @Override
    public void raiseRamp(double angle) { // innebär att lyfta flaket från marken för att sedan kunna köra
        if (getCurrentSpeed() == 0 && getAngle() - angle >= 0 && angle >= 0) {
            decrementAngle(angle);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or minimum angle is allowed to be 0 degrees.");
        }
    }
    @Override
    protected int getSize(){
        return 3;} //large

    }

