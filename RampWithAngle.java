public class RampWithAngle implements TruckPlatform {
    private int maxAngle; //maximalt tillåtna vinkel
    private int rampAngle; //nuvarande vinkel
    private boolean isRampOn; // true = ramp används, går att lasta | false = ramp används inte, går att köra

    public RampWithAngle(int maxAngle) {
        this.maxAngle = maxAngle;
        this.rampAngle = 0;
        this.isRampOn = false;
    }

    public void setRamp(int angle) {
        checkAngle(angle);
        changeAngleWithAmount(angle);
    }

    private void changeAngleWithAmount(int angle) {
        this.rampAngle += angle;
        this.isRampOn  = (angle > 0) ? true : false; //skriva bara degree > 0?
    }

    private boolean checkAngle(double angle){
        if(!angleIntervall(angle)) throw new IllegalStateException("You can not set the ramp to this angle");
        if(checkRampIsUp(angle)) throw new IllegalStateException("The ramp is already Up");
        if(checkRampIsDown(angle)) throw new IllegalStateException("The platform is already Down");
        else {return true;}
    }

    private void incrementAngle(double angle) {
        this.rampAngle += angle;
    }

    private void decrementAngle(double angle) {
        this.rampAngle -= angle;
    }

    @Override
    public void lowerRamp() {
        lowerRamp(0);
    }

    public void lowerRamp(double angle) { // sänka flaket för att kunna lasta på
        if (checkAngle(angle)) {
            incrementAngle(angle);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or maximum angle is allowed to be 70 degrees.");
        }
    }

    @Override
    public void raiseRamp() {
        raiseRamp1(70);
    }
    public void raiseRamp1(double angle) { // innebär att lyfta flaket från marken för att sedan kunna köra
        if (checkAngle(angle)) {
            decrementAngle(angle);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or minimum angle is allowed to be 0 degrees.");
        }
    }

    private boolean checkRampIsUp(double angle){
        return rampAngle == maxAngle && angle == maxAngle;
    }

    private boolean checkRampIsDown(double angle){
        return rampAngle == 0 && angle == 0;
    }

    private boolean angleIntervall(double angle){
        return angle <= maxAngle && angle >= 0;
    }

    public boolean getIsRampOn() {
        return this.isRampOn;
    }

    public int getRampAngle() {
        return rampAngle;
    }

}
