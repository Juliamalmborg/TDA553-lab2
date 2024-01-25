import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck {

        private boolean rampIsUp; //Rampen är antingen uppe eller nere
        private ArrayList<Vehicle> carsOnRamp; //array som innehåller antal bilar som finns på rampen.
        private int maxCapacity; //Biltransporten har ett maximalt antal bilar som den kan lasta.
        private double maxSizeCar; //Bilar som ska lastas på biltransporten får inte vara för stora (eget antagande)

        public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
            super(nrDoors, color, enginePower, modelName);
            this.rampIsUp = true;
            this.carsOnRamp = new ArrayList<>();
            this.maxCapacity = maxCapacity;
            this.maxSizeCar = maxSizeCar;
        }

        public void LoadRamp(Vehicle car){ // Bilar kan endast lastas om rampen är nere och är mindre än maxcapacity
            // måste vara fler if-satser här. Att bilen är av rätt storlek samt att den är nära nog.
            try{
            if (!rampIsUp && carsOnRamp.size() < maxCapacity)
                {carsOnRamp.add(car);}
                else {
                throw new Exception();
            }
            } catch (Exception e) {
                System.out.println("The car cannot be loaded. Check position of ramp, capacity, car size and distance.");
            }}

        @Override
        protected double speedFactor(){return getEnginePower() * 0.01;}
    }

