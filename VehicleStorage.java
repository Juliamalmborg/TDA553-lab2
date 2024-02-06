import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class VehicleStorage<T extends Vehicle> implements Loadable<T> {
    private List <T> loadedVehicles;
    private int maxCapacity;

    public VehicleStorage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.loadedVehicles = loadedVehicles;
    }

    @Override
    public void loadCar(T car) {  // gör två subklasser FIFOstorage, LIFOstorage av vehiclestorage DETTA ÄR ETT PROBLEM!
        if (getNrCars() >= maxCapacity) {
            throw new IllegalArgumentException("The storage is full");
        }
    }
    @Override
    public T unloadCar(T car) {
        if (getNrCars() == 0) {
            throw new IllegalArgumentException("The storage is empty");}
        return car;
    }

    public List<T> getLoadedVehicles() {
        return loadedVehicles;}

    public int getNrCars() {
        return loadedVehicles.size();
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

}

