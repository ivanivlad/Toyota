package car.passenger.cabriolet;

import car.Color;
import car.passenger.PassengerCar;

public abstract class Cabriolet extends PassengerCar {
    private boolean isRoofFolded = false;

    public Cabriolet(Color color, double price) {
        super(color, price);
    }

    public boolean isRoofFolded() {
        return isRoofFolded;
    }

    public void unfoldRoof() {
        isRoofFolded = false;
    }

    public void foldRoof() {
        isRoofFolded = true;
    }
}
