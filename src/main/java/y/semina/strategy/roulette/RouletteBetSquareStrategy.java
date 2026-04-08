package y.semina.strategy.roulette;

import java.math.BigDecimal;

/**
 * Стратегия ставки на четыре номера (каре) в рулетке.
 */
public class RouletteBetSquareStrategy implements RouletteStrategy {
    private static final BigDecimal SQUARE_MULTIPLY = BigDecimal.valueOf(8);

    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        System.out.println("Нет реализации");
        return BigDecimal.ZERO;
    }
}
