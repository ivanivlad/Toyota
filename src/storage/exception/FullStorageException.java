package storage.exception;

public class FullStorageException extends Exception {
    @Override
    public String getMessage() {
        return "На складе нет мест";
    }
}
