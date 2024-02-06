import java.util.ArrayList;
import java.util.List;

public class FifoStorage<T extends Vehicle> extends VehicleStorage { //ej stack add remocce
    private ArrayList<Vehicle> loadedVehicles;

    public FifoStorage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public void loadCar(Vehicle car) {
        loadedVehicles.addLast(car);
    }

    @Override
    public Vehicle unloadCar(Vehicle car){
        return loadedVehicles.removeFirst();
    }
}
