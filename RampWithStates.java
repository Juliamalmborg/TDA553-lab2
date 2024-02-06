public class RampWithStates implements TruckPlatform {
    private boolean isRampOn; //true = rampen används, den är nere | false = rampen anbänds inte, den är uppe på flaket

    public void lowerRamp() {
        isRampOn = true;
    }

    public void raiseRamp() {
        isRampOn = false;
    }
    public RampWithStates() {
        this.isRampOn = false;
    }

    public boolean getIsRampOn() {
        return isRampOn;
    }


}
