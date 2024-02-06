import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Vehicle> { // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private final FifoStorage<T> storageInWorkshop;


    public CarWorkshop(int maxCapacity) {
        storageInWorkshop = new FifoStorage<>(maxCapacity);
    }

    public void loadCar(T car) {
            storageInWorkshop.loadCar(car);
        }
    public Vehicle unloadCar(Vehicle car) {
            return storageInWorkshop.unloadCar(car);
    }

}
