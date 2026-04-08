package y.semina.factory;

import y.semina.model.enums.RouletteGameType;
import y.semina.strategy.roulette.*;

import static y.semina.util.ConsoleUtils.print;
import static y.semina.util.ConsoleUtils.printChoiceMenu;

/**
 * Фабрика для создания стратегий игры в рулетку.
 * Выбирает тип ставки на основе ввода пользователя.
 */
public class RouletteGameFactory {
    /**
     * Создаёт и возвращает стратегию рулетки в зависимости от выбранной пользователем ставки.
     *
     * @return объект RouletteStrategy для выбранного типа ставки
     */
    public static RouletteStrategy createRouletteGame() {
        while (true) {
            int betChoice = printChoiceMenu(
                    "Выбери ставку:" +
                            "\n0 - прямая ставка - на один номер" +
                            "\n1 - ставка на два соседних номера" +
                            "\n2 - ставка на три номера" +
                            "\n3 - каре (Нет реализации)" +
                            "\n4 - ставка на шесть номеров (Нет реализации)" +
                            "\n5 - четные" +
                            "\n6 - нечетные" +
                            "\n7 - черные" +
                            "\n8 - красные"
            );
            try {
                return switch (RouletteGameType.fromBetChoice(betChoice)) {
                    case BET_STRAIGHT_ONE -> new RouletteBetStraightOneStrategy();
                    case BET_SPLIT -> new RouletteBetSplitStrategy();
                    case BET_STRAIGHT_THREE -> new RouletteBetStraightThreeStrategy();
                    case BET_SQUARE -> new RouletteBetSquareStrategy();
                    case BET_SIX -> new RouletteBetSixStrategy();
                    case BET_EVEN -> new RouletteBetEvenStrategy();
                    case BET_ODD -> new RouletteBetOddStrategy();
                    case BET_BLACK -> new RouletteBetBlackStrategy();
                    case BET_RED -> new RouletteBetRedStrategy();
                };
            } catch (Exception e) {
                print("Неверный выбор, попробуй снова.");
            }
        }
    }
}
