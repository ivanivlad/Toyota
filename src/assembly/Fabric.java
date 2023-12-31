package assembly;

import car.Country;
import machineparts.Electrics;
import machineparts.Engine;
import machineparts.GasTank;
import machineparts.Headlights;
import machineparts.Wheel;

public class Fabric {
    public final Country country;

    public Fabric(Country country) {
        this.country = country;
    }

    public Wheel makeWheel(int diameter) {
        return new Wheel(diameter);
    }

    public Engine makeEngine() {
        return new Engine();
    }

    public Headlights makeHeadlights() {
        return new Headlights();
    }

    public Electrics makeElectrics() {
        return new Electrics();
    }

    public GasTank makeGasTank() {
        return new GasTank();
    }

    public Country getCountry() {
        return country;
    }

}
