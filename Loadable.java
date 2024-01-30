public interface Loadable<T extends Vehicle>  {

    void LoadCar(T car);

    T UnloadCar();
}
