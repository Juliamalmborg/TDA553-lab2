import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class VehicleStorage<T extends Vehicle> implements Loadable<T> {
    private List <T> loadedVehicles;
    private int maxCapacity;

    public VehicleStorage(int maxCapacity, List<T> loadedVehicles) {
        this.maxCapacity = maxCapacity;
        this.loadedVehicles = loadedVehicles;
    }

    @Override
    public void loadCar(T car) {
        if (getNrCars() >= maxCapacity) {
            throw new IllegalArgumentException("The storage is full");
        }
        else if (loadedVehicles instanceof Stack) {
            ((Stack<T>) loadedVehicles).push(car);
        }
        else {
            loadedVehicles.addLast(car);
    }
}
    @Override
    public T unloadCar(T car) {
        if (getNrCars() == 0) {
            throw new IllegalArgumentException("The storage is empty");
        }
        else if (loadedVehicles instanceof Stack<T>) {
            return ((Stack<T>) loadedVehicles).pop();
        }
        else {
            return loadedVehicles.removeLast();
    }}

    public List<T> getLoadedVehicles() {
        return loadedVehicles;}

    public int getNrCars() {
        return loadedVehicles.size();
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

}

