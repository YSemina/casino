package y.semina.strategy.roulette;

import java.math.BigDecimal;

/**
 * Стратегия ставки на нечётное число в рулетке.
 * Выигрыш выплачивается в соотношении 2:1 при выпадении нечётного номера.
 */
public class RouletteBetOddStrategy implements RouletteStrategy {
    private static final BigDecimal ODD_MULTIPLY = BigDecimal.valueOf(2);

    /**
     * Играет в рулетку со ставкой на нечётное число.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×2 при выпадении нечётного номера, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        int number = spinWheel().number();
        return (number % 2 != 0) ? betAmount.multiply(ODD_MULTIPLY) : BigDecimal.ZERO;
    }
}
