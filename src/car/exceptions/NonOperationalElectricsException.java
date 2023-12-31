package car.exceptions;

public class NonOperationalElectricsException extends StartCarException {
    private static final String MESSAGE_TEMPLATE = "сбой электрики";

    @Override
    public String getMessage() {
        return super.getMessage() + MESSAGE_TEMPLATE;
    }
}
