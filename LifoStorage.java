import java.util.Stack;

public class LifoStorage<T extends Vehicle> extends VehicleStorage{

    private Stack<Vehicle> loadedVehicles;

    public LifoStorage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public void loadCar(Vehicle car) {
        loadedVehicles.push(car);
    }

    @Override
    public Vehicle unloadCar(Vehicle car){
        return loadedVehicles.pop();
    }
}
