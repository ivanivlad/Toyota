package car.exceptions;

public class PuncturedWheelException extends StartCarException {
    private static final String MESSAGE_TEMPLATE = "проколото %d-е колесо";
    private final int numOfProblemWheel;

    public PuncturedWheelException(int numOfProblemWheel) {
        this.numOfProblemWheel = numOfProblemWheel;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + String.format(MESSAGE_TEMPLATE, numOfProblemWheel);
    }
}
