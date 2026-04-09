package y.semina.strategy.roulette;

import java.math.BigDecimal;

/**
 * Стратегия ставки на чётное число в рулетке.
 * Выигрыш выплачивается в соотношении 2:1 при выпадении чётного номера.
 */
public class RouletteBetEvenStrategy implements RouletteStrategy {
    private static final BigDecimal EVEN_MULTIPLY = BigDecimal.valueOf(2);

    /**
     * Играет в рулетку со ставкой на чётное число.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×2 при выпадении чётного номера, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        int number = spinWheel().number();
        return (number % 2 == 0) ? betAmount.multiply(EVEN_MULTIPLY) : BigDecimal.ZERO;
    }
}
