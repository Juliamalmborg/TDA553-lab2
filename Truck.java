import java.awt.*;

// ska vara superklass till scania och carTransport


public abstract class Truck extends Vehicle {
    private boolean truckRamp; // har ramp
    private  double rampAngle; // måste interageras i CarTransports olika lägen

    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
        this.truckRamp = true;
        this.rampAngle = 0; //flaket upp på lastbilen, körläge!!
    }

    public double getAngle(){ // ska vara private, protected i class truck
        return rampAngle;
    }

    protected void setAngle(double angle){
        this.rampAngle = angle;
    }

    @Override //för att kunna köra bilen efter lastning
    public void startEngine() {
        if (rampAngle == 0) {
            super.startEngine();
        }
    }

    @Override
    protected double speedFactor(){return getEnginePower() * 0.01;}

    @Override
    public void gas(double amount){
        if (amount >= 0 && amount <= 1 && rampAngle == 0) {
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("The number is not valid, or the ramp is down. Please choose a value between 0 and 1");
        }}

}
