import java.awt.*;
public class Scania extends Truck implements TruckPlatform{
    private boolean rampIsUp;
    private double rampAngle;

    public Scania(){
        super(2, Color.blue, 200, "Scania");
        this.rampIsUp = true;
        this.rampAngle = 0; //Startvärden
    }

    private void incrementAngle(double angle) {
        setAngle(getAngle() + angle);
    }

    private void decrementAngle(double angle) {
        setAngle(getAngle() - angle);
    }

    @Override
    public boolean isRampUp() {
        return rampIsUp;
    }
    @Override
    public void setRampState(boolean rampState) {

    }
    @Override
    public void lowerRamp(double angle) { // sänka flaket för att kunna lasta på
        if (getCurrentSpeed() == 0 && angle + getAngle() < 70 && angle >= 0) {
            incrementAngle(angle);
            setRampState(false);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or maximum angle is allowed to be 70 degrees.");
        }
        }
    @Override
    public void raiseRamp(double angle) { // innebär att lyfta flaket från marken för att sedan kunna köra
        if (getCurrentSpeed() == 0 && getAngle() - angle >= 0 && angle >= 0) {
            decrementAngle(angle);
            setRampState(true);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or minimum angle is allowed to be 0 degrees.");
        }
    }

    @Override
    protected int getSize(){
        return 3;} //large

    }

