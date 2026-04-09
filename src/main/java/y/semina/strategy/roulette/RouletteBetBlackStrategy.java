package y.semina.strategy.roulette;

import y.semina.model.enums.RouletteCellColorType;

import java.math.BigDecimal;

/**
 * Стратегия ставки на чёрное в рулетке.
 * Выигрыш выплачивается в соотношении 2:1 при выпадении чёрного.
 */
public class RouletteBetBlackStrategy implements RouletteStrategy {
    private static final BigDecimal BLACK_MULTIPLY = BigDecimal.valueOf(2);

    /**
     * Играет в рулетку со ставкой на чёрное.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×2 при выпадении чёрного, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        RouletteCellColorType rouletteCellColorType = spinWheel().rouletteCellColorType();
        return (rouletteCellColorType.equals(RouletteCellColorType.BLACK)) ? betAmount.multiply(BLACK_MULTIPLY) : BigDecimal.ZERO;
    }
}
