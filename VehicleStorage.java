import java.awt.*;
import java.util.ArrayList;

public class VehicleStorage<T extends Vehicle> implements Loadable<T> {
    private ArrayList <T> loadedVehicles;
    private int maxCapacity;

    public VehicleStorage(int maxCapacity) {
        loadedVehicles = new ArrayList<>(maxCapacity);
    }

    @Override
    public void loadCar(T car) {
        if (inProximity(car)){
            loadedVehicles.addLast(car);
            car.setXpos(x);
            car.setYpos(y);
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


}

