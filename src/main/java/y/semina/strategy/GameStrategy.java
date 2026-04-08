package y.semina.strategy;

import java.math.BigDecimal;

/**
 * Стратегия игры.
 */
public interface GameStrategy {
    /**
     * Запускает игру с указанной ставкой.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (может быть меньше ставки при проигрыше)
     */
    BigDecimal playGame(BigDecimal betAmount);
}
