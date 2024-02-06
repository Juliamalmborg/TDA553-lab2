import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Vehicle> { // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private final VehicleStorage<T> storageInWorkshop; // final pga aldrig ändras?


    public CarWorkshop(int maxCapacity) { // vill skicka in i testerna
        storageInWorkshop = new VehicleStorage<T>(maxCapacity, new ArrayList<T>());
    }

    public void loadCar(T car) {
            storageInWorkshop.loadCar(car);
        }
    public T unloadCar(T car) {
            return storageInWorkshop.unloadCar(car);
    }

}
