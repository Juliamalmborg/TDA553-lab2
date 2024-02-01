import java.awt.*;
import java.util.Stack;
import static java.lang.Math.abs;

public class CarTransport extends Truck {
    /*private boolean rampIsUp; //Rampen är antingen uppe eller nere
    private Stack<Vehicle> carsOnRamp; //stack som innehåller antal bilar som finns på rampen.
    private int maxCapacity; //Biltransporten har ett maximalt antal bilar som den kan lasta.
    private double maxSizeCar; //Bilar som ska lastas på biltransporten får inte vara för stora (eget antagande)

    private int rampAngle; // för att uppdatera rampAngle i Truck??
    */

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

    /*public void loadCar(Vehicle car) {
        if (car instanceof CarTransport) {
            throw new IllegalArgumentException("Cannot load another CarTransport.");
        }
        if (!ramp.getIsRampOn() && storageCapacity.getNrCars() <= maxCapacity && distanceCarToTransporter(car)
                && car.getSize() <= maxSizeCar) {
            storageCapacity.;
            car.setXpos(this.getXpos());
            car.setYpos(this.getYpos());
        }
        else {
            throw new IllegalArgumentException("The car cannot be loaded. Check position of ramp, capacity, car size and distance.");}
    }

    public Vehicle unloadCar(){
        if (ramp.getIsRampOn() && storageCapacity.getLoadedCars() > 0) {  //unloadar just nu en och en,
            Vehicle unloadedcar = storageCapacity.removeLast();
            unloadedcar.setXpos(this.getXpos()+1); // Vill ha pos när CarTransport,
            return unloadedcar;
        }
        else {
            throw new IllegalArgumentException("The car cannot be unloaded. Check position of ramp or if ramp empty.");
        }
    }*/

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

