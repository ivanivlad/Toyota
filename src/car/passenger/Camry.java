package car.passenger;

import car.Color;
import car.GearboxType;

public class Camry extends PassengerCar {
    private static final boolean HAS_USB = true;

    public Camry(Color color, double price) {
        super(color, price);
        this.gearboxType = GearboxType.AUTO;
        this.wheelDiameter = 20;
    }

    public void connectMusicByUSB() {
        System.out.println("музыка включена");
    }
}
