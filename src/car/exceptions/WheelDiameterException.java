package car.exceptions;

public class WheelDiameterException extends Exception {
    @Override
    public String getMessage() {
        return "Колесо не подходит для этой машины";
    }
}
