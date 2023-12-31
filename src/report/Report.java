package report;

import car.Car;
import car.ModelCost;

public class Report {
    private final ModelCost carModel;
    private final double income;
    private final double costPrice;

    public Report(Car car) {
        ModelCost modelCost = ModelCost.getModelByClass(car.getClass());
        this.carModel = modelCost;
        this.income = car.getPrice();
        this.costPrice = modelCost.getCost();
    }

    public double getIncome() {
        return income;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public String getModel() {
        return carModel.name();
    }
}
