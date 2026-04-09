package y.semina.strategy.roulette;

import java.math.BigDecimal;

/**
 * Стратегия ставки на шесть номеров в рулетке.
 */
public class RouletteBetSixStrategy implements RouletteStrategy {
    private static final BigDecimal SIXLINE_MULTIPLY = BigDecimal.valueOf(6);

    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        System.out.println("Нет реализации");
        return BigDecimal.ZERO;
    }
}
