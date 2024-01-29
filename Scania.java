import java.awt.*;
public class Scania extends Truck{
    private boolean truckRamp;
    private  double rampAngle;


    public Scania(){
        super(2, Color.blue, 200, "Scania");
        truckRamp = true;
        rampAngle = 0;
    }

    protected void incrementAngle(double angle) {
        rampAngle += angle;
    }

    protected void decrementAngle(double angle) {
        rampAngle -= angle;
    }

    public void liftRamp(double angle) {
        try {
            if (getCurrentSpeed() == 0 && angle + getAngle() < 70 && angle >= 0) {
                incrementAngle(angle);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Maximum angle is allowed to be 70 degrees.");
        }}

    public void lowerRamp(double angle) { //köra stopEngine inna try-catch??
        try {
            if (getCurrentSpeed() == 0 && getAngle() - angle >= 0 && angle >= 0) {
                decrementAngle(angle);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Minimum angle is allowed to be 0 degrees.");
        }}


    /*@Override //går denna att ta bort nu??
    public void gas(double amount) {
        try {if (rampAngle == 0 && amount >= 0 && amount <= 1)  {
            incrementSpeed(amount);
        }
        else {
            throw new Exception();
        }
        } catch (Exception e) {
            System.out.println("Truck cannot move when the ramp is up. Please lower the ramp.");
        }
    }*/


    }

