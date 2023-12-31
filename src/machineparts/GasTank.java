package machineparts;

public class GasTank {
    private int amount = 0;

    public int getAmount() {
        return amount;
    }

    public void fillUp(int amount) {
        this.amount = amount;
    }
}
