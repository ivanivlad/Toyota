package car.exceptions;

public class NonOperationalEngineException extends StartCarException {
    private static final String MESSAGE_TEMPLATE = "сбой работы двигателя";

    @Override
    public String getMessage() {
        return super.getMessage() + MESSAGE_TEMPLATE;
    }
}
