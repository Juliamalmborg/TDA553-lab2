import java.awt.*;
import java.util.Stack;

import static java.lang.Math.abs;

public class CarTransport extends Truck implements Loadable{
    private boolean rampIsUp; //Rampen är antingen uppe eller nere
    private Stack<Vehicle> carsOnRamp; //stack som innehåller antal bilar som finns på rampen.
    private int maxCapacity; //Biltransporten har ett maximalt antal bilar som den kan lasta.
    private double maxSizeCar; //Bilar som ska lastas på biltransporten får inte vara för stora (eget antagande)

    private int rampAngle; // för att uppdatera rampAngle i Truck??

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.rampIsUp = true;
        this.carsOnRamp = new Stack<>();
        this.maxCapacity = 10;
        this.maxSizeCar = 2;
        this.rampAngle = 70; // 70 anses som uppe och 0 nere
        }

    @Override
    public void LoadCar(Vehicle car) {
        if (car instanceof CarTransport) {
            throw new IllegalArgumentException("Cannot load another CarTransport.");
        }
        if (!rampIsUp && carsOnRamp.size() <= maxCapacity && distanceCarToTransporter(car)
                && car.getSize() <= maxSizeCar) {
            carsOnRamp.push(car);
            car.setXpos(this.getXpos());
            car.setYpos(this.getYpos());
        }
        else {
            throw new IllegalArgumentException("The car cannot be loaded. Check position of ramp, capacity, car size and distance.");}
    }

    @Override
    public Vehicle UnloadCar(){
        if (!rampIsUp && !carsOnRamp.isEmpty()) {  //unloadar just nu en och en,
            Vehicle unloadedcar = carsOnRamp.pop();
            unloadedcar.setXpos(this.getXpos()+1); // Vill ha pos när CarTransport,
            return unloadedcar;
        }
        else {
            throw new IllegalArgumentException("The car cannot be unloaded. Check position of ramp or if ramp empty.");
        }
    }

    public void raiseRamp(){
        rampIsUp = true;
        rampAngle = 70;
    }

    public void lowerRamp(){
        rampIsUp = false;
        rampAngle = 0;
    }

    protected int getnrCarsOnRamp(){
        return this.carsOnRamp.size();
    }

    public boolean distanceCarToTransporter(Vehicle car) {
        return Math.abs(this.getXpos() - car.getXpos()) < 2 && Math.abs(this.getYpos() - car.getYpos()) < 2;
    }
    @Override
    protected double speedFactor(){return getEnginePower() * 0.01;}

    @Override
    protected int getSize(){
        return 3;} //large
    }

