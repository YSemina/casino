package y.semina.exception;

/**
 * Исключение, выбрасываемое при попытке взять карту из пустой колоды.
 */
public class DeckIsEmptyException extends RuntimeException {
    public DeckIsEmptyException(String message) {
        super(message);
    }
}
