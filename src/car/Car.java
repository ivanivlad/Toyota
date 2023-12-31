package car;

import car.exceptions.NonOperationalElectricsException;
import car.exceptions.NonOperationalEngineException;
import car.exceptions.OutOfFuelException;
import car.exceptions.OutOfWheelException;
import car.exceptions.PuncturedWheelException;
import car.exceptions.StartCarException;
import car.exceptions.WheelDiameterException;
import machineparts.Electrics;
import machineparts.Engine;
import machineparts.GasTank;
import machineparts.Headlights;
import machineparts.Wheel;

public abstract class Car {
    public static final int MAX_WHEELS = 4;
    protected int maxSpeed = 0;
    protected boolean inMotion = false;
    protected Color color;
    protected GearboxType gearboxType;
    protected Wheel[] wheels;
    protected int wheelDiameter;
    protected GasTank gasTank;
    protected Engine engine;
    protected Electrics electrics;
    protected Headlights headlights;
    protected double price;
    protected Country country;

    public Car(Color color, double price) {
        this.color = color;
        this.price = price;
        this.wheels = new Wheel[MAX_WHEELS];
    }

    public void startMotion() throws StartCarException {
        for (int i = 1; i <= MAX_WHEELS; i++) {
            if (wheels[i - 1] == null) {
                throw new OutOfWheelException(i);
            } else if (wheels[i - 1].isPunctured()) {
                throw new PuncturedWheelException(i);
            }
        }
        if (gasTank.getAmount() == 0) {
            throw new OutOfFuelException();
        }
        if (!electrics.isOperational()) {
            throw new NonOperationalElectricsException();
        }
        if (!engine.isOperational()) {
            throw new NonOperationalEngineException();
        }

        this.inMotion = true;
    }

    public void stopMotion() {
        this.inMotion = false;
    }

    public void switchOnHeadLights() {
        if (!headlights.isOperational()) {
            System.out.println("фары включены");
        } else {
            System.out.println("не удалось включить фары");
        }
    }

    public void setupGasTank(GasTank gasTank) {
        this.gasTank = gasTank;
    }

    public void setupEngine(Engine engine) {
        this.engine = engine;
    }

    public void setupElectrics(Electrics electrics) {
        this.electrics = electrics;
    }

    public void setupHeadlights(Headlights headlights) {
        this.headlights = headlights;
    }

    public void setupWheel(Wheel wheel, int wheelNumber) {
        if (wheelNumber < 1 || wheelNumber > MAX_WHEELS) {
            throw new RuntimeException("Нет колеса с таким номером");
        }

        try {
            checkWheelDiameter(wheel);
        } catch (WheelDiameterException e) {
            throw new RuntimeException(e);
        }

        this.wheels[wheelNumber - 1] = wheel;
    }

    protected void checkWheelDiameter(Wheel wheel) throws WheelDiameterException {
        if (wheel.getDiameter() != wheelDiameter) {
            throw new WheelDiameterException();
        }
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }
}
