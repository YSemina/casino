package y.semina.strategy.roulette;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.printChoiceMenu;

/**
 * Стратегия прямой ставки на один номер в рулетке.
 * Выигрыш выплачивается в соотношении 35:1 при совпадении с выбранным номером.
 */
public class RouletteBetStraightOneStrategy implements RouletteStrategy {
    private static final BigDecimal STRAIGHT_BET_MULTIPLY = BigDecimal.valueOf(35);

    /**
     * Играет в рулетку со ставкой на один номер.
     * Пользователь вводит число от 1 до 36.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×35 при совпадении, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        int usersNumber = printChoiceMenu("Введи число от 1 до 36");
        if (usersNumber < 1 || usersNumber > 36) {
            System.out.println("Нужно ввести число от 1 до 36");
            return playGame(betAmount);
        }
        int number = spinWheel().number();
        return (number == usersNumber) ? betAmount.multiply(STRAIGHT_BET_MULTIPLY) : BigDecimal.ZERO;
    }
}
