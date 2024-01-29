import java.util.ArrayList;

public class CarWorkshop<T extends Vehicle> { // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    // kan sedan använda T i metoderna nedan för CarWorkshop
    //
    private ArrayList<T> carsInWorkshop;
    private int maxCapacity;

    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.carsInWorkshop = new ArrayList<>();
    }

    public void LoadedCars(T Vehicle){}
}
