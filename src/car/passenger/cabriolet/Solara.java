package car.passenger.cabriolet;

import car.Color;
import car.GearboxType;

public class Solara extends Cabriolet {
    private static final boolean HAS_FREEZER = true;

    public Solara(Color color, double price) {
        super(color, price);
        this.gearboxType = GearboxType.MECHANIC;
        this.wheelDiameter = 16;
    }

    public void coolDrink() {
        System.out.println("напиток охлажден");
    }

}
