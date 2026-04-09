package y.semina.strategy.roulette;

import y.semina.model.enums.RouletteCellColorType;

import java.math.BigDecimal;

/**
 * Стратегия ставки на красное в рулетке.
 * Выигрыш выплачивается в соотношении 2:1 при выпадении красного.
 */
public class RouletteBetRedStrategy implements RouletteStrategy {
    private static final BigDecimal RED_MULTIPLY = BigDecimal.valueOf(2);

    /**
     * Играет в рулетку со ставкой на красное.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×2 при выпадении красного, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        RouletteCellColorType rouletteCellColorType = spinWheel().rouletteCellColorType();
        return rouletteCellColorType.equals(RouletteCellColorType.RED) ? betAmount.multiply(RED_MULTIPLY) : BigDecimal.ZERO;
    }
}
