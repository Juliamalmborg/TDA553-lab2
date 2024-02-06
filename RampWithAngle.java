public class RampWithAngle implements TruckPlatform {
    private double maxAngle; //maximalt tillåtna vinkel
    private double rampAngle; //nuvarande vinkel
    private boolean isRampOn; // true = ramp används, går att lasta | false = ramp används inte, går att köra

    public RampWithAngle(double maxAngle) {
        this.maxAngle = maxAngle;
        this.rampAngle = 0;
        this.isRampOn = false;
    }

    private boolean checkAngle(double angle){
        if(!angleIntervall(angle)) throw new IllegalStateException("You can not set the ramp to this angle");
        else if(checkRampIsUp(angle)) throw new IllegalStateException("The ramp is already Up");
        else if(checkRampIsDown(angle)) throw new IllegalStateException("The platform is already Down");
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
        lowerRamp(70);
    }

    public void lowerRamp(double angle) { // sänka flaket för att kunna lasta på
        if (checkAngle(angle) && rampAngle + angle <= 70) {
            incrementAngle(angle);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or maximum angle is allowed to be 70 degrees.");
        }
    }

    @Override
    public void raiseRamp() {
        raiseRamp(0);
    }
    public void raiseRamp(double angle) { // innebär att lyfta flaket från marken för att sedan kunna köra
        if (checkAngle(angle) && rampAngle - angle >= 0) {
            decrementAngle(angle);
        } else {
            throw new IllegalArgumentException("Can not have a speed and/or minimum angle is allowed to be 0 degrees.");
        }
    }

    private boolean checkRampIsDown(double angle){
        return angle == maxAngle;
    }

    private boolean checkRampIsUp(double angle){
        return angle == 0;
    }

    private boolean angleIntervall(double angle){
        return angle <= maxAngle && angle  >= 0;
    }

    public boolean getIsRampOn() {
        return this.isRampOn;
    }

    public double getRampAngle() {
        return this.rampAngle;
    }

    public double getMaxAngle() {
        return maxAngle;
    }

}