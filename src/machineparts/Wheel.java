package machineparts;

public class Wheel {
    private boolean isPunctured = false;
    private final int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
    }

    public boolean isPunctured() {
        return isPunctured;
    }

    public void setPunctured() {
        isPunctured = true;
    }

    public int getDiameter() {
        return diameter;
    }
}
