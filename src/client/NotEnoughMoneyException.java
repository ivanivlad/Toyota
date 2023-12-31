package client;

public class NotEnoughMoneyException extends Exception {
    @Override
    public String getMessage() {
        return "Сир, нужно больше золота!";
    }
}
