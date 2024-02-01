import java.awt.*;

// ska vara superklass till scania och carTransport
public abstract class Truck extends Vehicle {
    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
    }

    @Override //för att kunna köra bilen efter lastning
    public void startEngine() {
        if (!checkMovable()) throw new IllegalStateException("You can't start the engine while platform is down.");
        if (getCurrentSpeed() > 0.1) throw new IllegalStateException("You have already started the engine");
        super.startEngine();
        }

    @Override
    protected double speedFactor(){return getEnginePower() * 0.01;}

    @Override
    public void gas(double amount){
        if (amount >= 0 && amount <= 1 && getIsRampOn()) {
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("The number is not valid, or the ramp is down. Please choose a value between 0 and 1");
        }}

    private boolean checkMovable() {
        if (getIsRampOn()) {
            setMovable(false);
        } else {
            setMovable(true);
        }
        return isMovable();
    }

    public abstract boolean getIsRampOn();

}
