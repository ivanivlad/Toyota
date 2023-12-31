package car;

import car.passenger.Camry;
import car.passenger.cabriolet.Solara;
import car.truck.Dyna;
import car.truck.Hiance;

public enum ModelCost {
    CAMRY(5_000, Camry.class),
    SOLARA(8_000, Solara.class),
    HIANCE(10_000, Hiance.class),
    DYNA(12_000, Dyna.class);
    private final double cost;
    private final Class clazz;

    ModelCost(double cost, Class clazz) {
        this.cost = cost;
        this.clazz = clazz;
    }

    public static ModelCost getModelByClass(Class typeOfClass) {
        for (var value : values()) {
            if (value.clazz.equals(typeOfClass)) {
                return value;
            }
        }
        throw new RuntimeException("для класса отсутствует запись в справочнике моделей");
    }

    public double getCost() {
        return cost;
    }
}
