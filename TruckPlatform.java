public interface TruckPlatform {
    boolean isRampUp();
    void lowerRamp(double angle);
    void raiseRamp(double angle);
    void setRampState(boolean rampState);
}
