package assembly;

import car.Car;
import car.Country;
import car.passenger.Camry;
import car.passenger.cabriolet.Solara;
import car.truck.Dyna;
import car.truck.Hiance;
import machineparts.Wheel;

public class AssemblyLine {
    private final Country country;
    private Fabric fabric;

    public AssemblyLine(Country country) {
        this.country = country;
    }

    public void useFabric(Fabric fabric) {
        if (!fabric.getCountry().equals(country)) {
            throw new CountryFactoryNotEqualException(new Country[]{fabric.getCountry(), country});
        }
        this.fabric = fabric;
    }

    private void baseAssemblyCar(Car car) {
        if (fabric == null) {
            throw new RuntimeException("Установи фабрику через useFabric фабрику перед сборкой");
        }
        car.setupHeadlights(fabric.makeHeadlights());
        car.setupGasTank(fabric.makeGasTank());
        car.setupElectrics(fabric.makeElectrics());
        car.setupEngine(fabric.makeEngine());
        Wheel[] wheels = new Wheel[Car.MAX_WHEELS];
        for (int i = 0; i < Car.MAX_WHEELS; i++) {
            wheels[i] = fabric.makeWheel(car.getWheelDiameter());
        }



        for (int i = 0; i < Car.MAX_WHEELS; i++) {
            car.setupWheel(wheels[i], i + 1);
        }

        car.setCountry(country);
    }

    public Camry createCar(Camry car) {
        baseAssemblyCar(car);
        return car;
    }

    public Solara createCar(Solara car) {
        baseAssemblyCar(car);
        return car;
    }

    public Hiance createCar(Hiance car) {
        baseAssemblyCar(car);
        car.setupSpareWheel(fabric.makeWheel(car.getWheelDiameter()));
        return car;
    }

    public Dyna createCar(Dyna car) {
        baseAssemblyCar(car);
        return car;
    }

}
