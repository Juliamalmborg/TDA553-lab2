import java.awt.*;
import java.util.Stack;

import static java.lang.Math.abs;

public class CarTransport extends Truck {

    private final VehicleStorage<Vehicle> storage; //final pga inte ändras??
    private final RampWithStates ramp; //final pga inte ändras
    private int rampState;

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.ramp = new RampWithStates();
        storage = new VehicleStorage<Vehicle> (4, new Stack<Vehicle>());
    }

    public void loadCar(Vehicle car) {
        if (car instanceof Truck) { //Truck innefattar CarTransport och scania
            throw new IllegalArgumentException("Cannot load another Truck.");
        }
        else if (!inProximity(car)) {
            throw new IllegalArgumentException("Car is to far away, can not be loaded.");
        }
        else if (getIsRampOn()) {
            storage.loadCar(car);
            car.setXpos(this.getXpos());
            car.setYpos(this.getYpos());
        }
    }

    public Vehicle unloadCar(Vehicle car) {
        if (getIsRampOn()) {
             Vehicle unloadedCar = storage.unloadCar(car);
             car.setXpos(this.getXpos()+1);
             return unloadedCar;
        } else {
            throw new IllegalStateException("No cars to unload or the ramp is not down.");
        }
    }

    public boolean getIsRampOn() {
        return ramp.getIsRampOn();
    }

    protected int getnrCarsOnRamp(){
        return storage.getNrCars();
    }

    @Override
    protected double speedFactor(){return getEnginePower() * 0.01;}


    public boolean inProximity(Vehicle car) {
        return Math.abs(this.getXpos() - car.getXpos()) < 2 && Math.abs(this.getYpos() - car.getYpos()) < 2;
    }

    public void lowerRamp(){
        if (getCurrentSpeed()==0){
        ramp.lowerRamp();}
        else
        {
            throw new IllegalArgumentException("Truck cannot lower ramp while moving.");
        }
    }

    public void raiseRamp(){
        if (getCurrentSpeed() == 0){
        ramp.raiseRamp();}
        else {
            throw new IllegalArgumentException("Truck cannot raise ramp while moving.");
        }
    }
    }



