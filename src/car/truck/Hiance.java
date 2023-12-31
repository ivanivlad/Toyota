package car.truck;

import car.Color;
import car.GearboxType;
import car.exceptions.OutOfWheelException;
import car.exceptions.WheelDiameterException;
import machineparts.Wheel;

public class Hiance extends Truck {
    private Wheel spareWheel;

    public Hiance(Color color, double price) {
        super(color, price);
        this.carrying = 3000;
        this.gearboxType = GearboxType.ROBOT;
        this.wheelDiameter = 20;
    }

    public void getSpareWheel() throws OutOfWheelException {
        if (spareWheel == null) {
            throw new OutOfWheelException(5);
        }
        System.out.println("запасное колесо");
    }

    public void setupSpareWheel(Wheel spareWheel) {
        try {
            checkWheelDiameter(spareWheel);
        } catch (WheelDiameterException e) {
            throw new RuntimeException(e);
        }
        this.spareWheel = spareWheel;
    }

}
