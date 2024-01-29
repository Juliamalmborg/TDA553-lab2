import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport extends Truck{
    private boolean rampIsUp; //Rampen är antingen uppe eller nere
    private Stack<Vehicle> carsOnRamp; //array som innehåller antal bilar som finns på rampen.
    private int maxCapacity; //Biltransporten har ett maximalt antal bilar som den kan lasta.
    private double maxSizeCar; //Bilar som ska lastas på biltransporten får inte vara för stora (eget antagande)

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.rampIsUp = true;
        this.carsOnRamp = new Stack<>();
        this.maxCapacity = maxCapacity;
        this.maxSizeCar = 6;
        }
    public void LoadCar(Vehicle car){ // Bilar kan endast lastas om rampen är nere och är mindre än maxcapacity
            // måste vara fler if-satser här. Att bilen är av rätt storlek samt att den är nära nog.
        if (!rampIsUp && carsOnRamp.size() < maxCapacity && distanceCarToTransporter(car) == true && car.getSize() < maxSizeCar) {
            carsOnRamp.push(car);}
        else {
            throw new IllegalArgumentException("The car cannot be loaded. Check position of ramp, capacity, car size and distance.");}
    }

    public void UnloadCar(Vehicle car){
        if (!rampIsUp) {  //unloadar just nu en och en,
            carsOnRamp.pop();
            car.getXpos()
        }
        else {
            throw new IllegalArgumentException("The car cannot be unloaded. Check position of ramp.");
        }
    }

    public void raiseRamp(){
        rampIsUp = true;
    }

    public void lowerRamp(){
        rampIsUp = false;
    }

    public distanceCarToTransporter(Vehicle car) {
        if (xDistance = abs(this.getXpos() - car.getXpos()) < 2 &&
            yDistance = abs(this.getYpos() - car.getYpos()) < 2;)
            return true;
        else {
            return false;
        }
    }
    @Override
    protected double speedFactor(){return getEnginePower() * 0.01;}
    }

