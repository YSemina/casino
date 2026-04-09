package y.semina.strategy.roulette;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.printChoiceMenu;

/**
 * Стратегия ставки на три номера в рулетке.
 * Выигрыш выплачивается в соотношении 11:1 при попадании на один из трёх выбранных номеров.
 */
public class RouletteBetStraightThreeStrategy implements RouletteStrategy {
    private static final BigDecimal STRAIGHT_MULTIPLY = BigDecimal.valueOf(11);

    /**
     * Играет в рулетку со ставкой на три номера.
     * Пользователь вводит первое число (от 1 до 34), второе и третье = первое + 1 и первое + 2.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×11 при совпадении, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        int[] usersNumber = new int[3];
        usersNumber[0] = printChoiceMenu("Введи число от 1 до 34. " +
                "Второе и третье числа для ставки будет на 1 и 2 больше соответственно.");
        if (usersNumber[0] < 1 || usersNumber[0] > 34) {
            System.out.println("Нужно ввести число от 1 до 34");
            return playGame(betAmount);
        }
        usersNumber[1] = usersNumber[0] + 1;
        usersNumber[2] = usersNumber[0] + 2;

        int number = spinWheel().number();

        return (number == usersNumber[0] || number == usersNumber[1] || number == usersNumber[2]) ?
                betAmount.multiply(STRAIGHT_MULTIPLY) : BigDecimal.ZERO;
    }
}
