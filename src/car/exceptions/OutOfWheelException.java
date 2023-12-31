package car.exceptions;

public class OutOfWheelException extends StartCarException {
    private static final String MESSAGE_TEMPLATE = "нет %d колеса";
    private final int numOfProblemWheel;

    public OutOfWheelException(int numOfProblemWheel) {
        this.numOfProblemWheel = numOfProblemWheel;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + String.format(MESSAGE_TEMPLATE, numOfProblemWheel);
    }
}
