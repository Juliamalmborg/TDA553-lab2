import java.awt.*;
import static java.lang.Math.abs;

public class CarTransport extends Truck {

    private VehicleStorage<Vehicle> storageCapacity;
    private RampWithStates ramp;
    private int rampState;

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.ramp = new RampWithStates();
        this.storageCapacity = new VehicleStorage<Vehicle> (2);
    }

    public void loadCar(Vehicle car) {
        if (car instanceof CarTransport) {
            throw new IllegalArgumentException("Cannot load another CarTransport.");
        }
        if (getIsRampOn()) {
            storageCapacity.loadCar(car);
        }
    }

    public Vehicle unloadCar() {
        if (getIsRampOn()) {
             Vehicle unloadedCar = storageCapacity.unloadCar();
             return unloadedCar;
        } else {
            throw new IllegalStateException("No cars to unload or the ramp is not down.");
        }
    }

    public boolean getIsRampOn() {
        return ramp.getIsRampOn();
    }

    protected int getnrCarsOnRamp(){
        return storageCapacity.getNrCars();
    }

    @Override
    protected double speedFactor(){return getEnginePower() * 0.01;}

    @Override
    protected int getSize(){
        return 3;} //large

}

