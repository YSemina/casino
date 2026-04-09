package y.semina.strategy.roulette;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.printChoiceMenu;

/**
 * Стратегия ставки на два соседних номера в рулетке (сплит).
 * Выигрыш выплачивается в соотношении 17:1, если шарик попадает на один из двух выбранных номеров.
 */
public class RouletteBetSplitStrategy implements RouletteStrategy {
    private static final BigDecimal SPLIT_MULTIPLY = BigDecimal.valueOf(17);

    /**
     * Играет в рулетку со ставкой на два соседних номера.
     * Пользователь вводит первое число (от 1 до 35), второе число автоматически = первое + 1.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (сумма ×17 при совпадении, иначе 0)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        int[] usersNumber = new int[2];
        usersNumber[0] = printChoiceMenu("Введи число от 1 до 35. Второе число для ставки будет на 1 больше.");
        if (usersNumber[0] < 1 || usersNumber[0] > 35) {
            System.out.println("Нужно ввести число от 1 до 35");
            return playGame(betAmount);
        }
        usersNumber[1] = usersNumber[0] + 1;
        int number = spinWheel().number();
        if (number == usersNumber[0] || number == usersNumber[1]) {
            return betAmount.multiply(SPLIT_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }
}
