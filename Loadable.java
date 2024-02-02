public interface Loadable<T extends Vehicle>  {

    void loadCar(T car);

    T unloadCar();
}
