package y.semina.exception;

/**
 * Исключение, выбрасываемое при недостатке средств на счету игрока для совершения ставки.
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
