package storage.exception;

public class EmptyStorageException extends Exception {
    @Override
    public String getMessage() {
        return "На складе нет машин";
    }
}
