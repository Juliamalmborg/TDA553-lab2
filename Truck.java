import java.awt.*;

// ska vara superklass till scania och carTransport


public abstract class Truck extends Vehicle {
    private boolean truckRamp;
    private  double rampAngle;

    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
        this.truckRamp = true;
        this.rampAngle = 0;
    }

    protected double getAngle(){ // ska vara private, protected i class truck
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

}
