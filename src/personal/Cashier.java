package personal;

import car.Car;

public class Cashier {
    private double income = 0;

    public void addIncome(Car car) {
        income += car.getPrice();
    }

    public double getIncomeTotal() {
        return income;
    }
}
