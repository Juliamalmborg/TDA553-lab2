import java.util.ArrayList;

public class CarWorkshop<T extends Vehicle> implements Loadable <T>{ // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private ArrayList<T> carsInWorkshop;
    private int maxCapacity;

    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.carsInWorkshop = new ArrayList<>();
    }

    @Override
    public void LoadCar(T car) {
        if (carsInWorkshop.size() < maxCapacity)
            carsInWorkshop.add(car);
        else {
                throw new IllegalArgumentException("Cannot load another car to Workshop.");
            }
        }

    @Override
    public T UnloadCar() {
        if (carsInWorkshop.isEmpty()){
            throw new IllegalStateException("The Workshop is empty.");}
        else {
            return carsInWorkshop.removeFirst();
        }
    }

}
