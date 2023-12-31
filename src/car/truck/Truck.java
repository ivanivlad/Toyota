package car.truck;

import car.Car;
import car.Color;

public abstract class Truck extends Car {
    protected double carrying;

    public Truck(Color color, double price) {
        super(color, price);
    }

    public double getCarrying() {
        return carrying;
    }
}
