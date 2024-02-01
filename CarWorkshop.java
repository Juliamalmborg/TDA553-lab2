import java.util.ArrayList;

public class CarWorkshop<T extends Vehicle> { // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private VehicleStorage<T> storageInWorkshop;
    //eventuellt ska verkstad ha en position

    public CarWorkshop(int maxCapacity) {
        this.storageInWorkshop = new VehicleStorage<>(5);
    }

    public void loadCar(T car) {
        if (storageInWorkshop.getNrCars() < storageInWorkshop.getMaxCapacity()) {
            storageInWorkshop.loadCar(car);
        }
        else {
                throw new IllegalArgumentException("Cannot load another car to Workshop.");
            }
        }

    public T unloadCar() {
        if (storageInWorkshop.getNrCars() == 0){
            throw new IllegalStateException("The Workshop is empty, no cars to ");}
        else {
            return storageInWorkshop.unloadCar();
        }
    }

}
