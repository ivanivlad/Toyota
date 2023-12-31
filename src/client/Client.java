package client;

public class Client {
    private final String name;

    public void setAmountMoney(double amountMoney) {
        this.amountMoney = amountMoney;
    }

    private double amountMoney;

    public Client(String name, double amountMoney) {
        this.name = name;
        this.amountMoney = amountMoney;
    }

    public double shutUpAndTakeMyMoney() {
        return amountMoney;
    }
}
