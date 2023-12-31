package car.exceptions;

public class OutOfFuelException extends StartCarException {
    private static final String MESSAGE_TEMPLATE = "закончилось топливо";

    @Override
    public String getMessage() {
        return super.getMessage() + MESSAGE_TEMPLATE;
    }
}
