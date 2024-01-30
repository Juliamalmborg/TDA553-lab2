import java.util.ArrayList;

public class CarWorkshop<T extends Vehicle> implements Loadable <T>{ // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    // kan sedan använda T i metoderna nedan för CarWorkshop
    //
    private ArrayList<T> carsInWorkshop;
    private int maxCapacity;

    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.carsInWorkshop = new ArrayList<>();
    }

    @Override
    public void LoadCar(Vehicle car) {
        if (carsInWorkshop.size() < maxCapacity)
            carsInWorkshop.add((T) car);
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
