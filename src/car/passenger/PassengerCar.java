package car.passenger;

import car.Car;
import car.Color;

public abstract class PassengerCar extends Car {
    private boolean isCruiseControlWorking = false;

    public PassengerCar(Color color, double price) {
        super(color, price);
    }

    public boolean isCruiseControlWorking() {
        return isCruiseControlWorking;
    }

    public void switchOnCruiseControl() {
        isCruiseControlWorking = true;
    }

    public void switchOffCruiseControl() {
        isCruiseControlWorking = false;
    }
}
