package car.exceptions;

public abstract class StartCarException extends Exception {
    @Override
    public String getMessage() {
        return "Запуск не удался. Причина: ";
    }
}
