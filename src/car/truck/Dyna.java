package car.truck;

import car.Color;
import car.GearboxType;

public class Dyna extends Truck {
    private static final boolean HAS_SOCKET = true;

    public Dyna(Color color, double price) {
        super(color, price);
        this.carrying = 5000;
        this.gearboxType = GearboxType.ROBOT;
        this.wheelDiameter = 20;
    }

    public void chargeCell() {
        System.out.println("телефон заряжен");
    }

}
