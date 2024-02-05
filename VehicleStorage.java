import java.awt.*;
import java.util.ArrayList;

public class VehicleStorage<T extends Vehicle> implements Loadable<T> {
    private ArrayList <T> loadedVehicles;
    private int maxCapacity;
    private double xpos; //xpos of vehicleStorage
    private double ypos; //ypos of vehilceStorage

    public VehicleStorage(int maxCapacity) {
        loadedVehicles = new ArrayList<>(maxCapacity);
        this.maxCapacity = maxCapacity;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    @Override
    public void loadCar(T car) {
        if (inProximity(car)){
            loadedVehicles.addLast(car);
            car.setXpos(this.xpos);
            car.setYpos(this.ypos);
        }
    }
    @Override
    public T unloadCar() {
        loadedVehicles.remove(car);
        car.setXpos(x+1);
        car.setYpos(y+1);
    }
    public boolean inProximity(T car) {
        return Math.abs(this.getXpos() - car.getXpos()) < 2 && Math.abs(this.getYpos() - car.getYpos()) < 2;
    }

    public ArrayList<T> getLoadedVehicles() {
        return loadedVehicles;}

    public int getNrCars() {
        return loadedVehicles.size();
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public double getXpos() { return xpos; }
    public void setXpos(double xpos) { this.xpos = xpos; }
    public double getYpos() { return ypos; }
    public void setYpos(double ypos) { this.ypos = ypos; }
}

