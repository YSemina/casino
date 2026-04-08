package y.semina.factory;

import y.semina.model.enums.GameType;
import y.semina.strategy.GameStrategy;
import y.semina.strategy.blackjack.BlackjackStrategy;

import static y.semina.util.ConsoleUtils.print;
import static y.semina.util.ConsoleUtils.printChoiceMenu;

/**
 * Фабрика для создания игровых стратегий.
 * Выбирает тип игры (рулетка или блэкджек) на основе ввода пользователя.
 */
public class GameFactory {
    /**
     * Создаёт и возвращает игровую стратегию в зависимости от выбора пользователя.
     *
     * @return объект GameStrategy для выбранной игры
     */
    public static GameStrategy createGame() {
        while (true) {
            int gameChoice = printChoiceMenu(
                    "Выбери игру:" +
                            "\n0 - рулетка" +
                            "\n1 - блэкджек");

            try {
                return switch (GameType.fromPlayerChoice(gameChoice)) {
                    case ROULETTE -> RouletteGameFactory.createRouletteGame();
                    case BLACKJACK -> new BlackjackStrategy();
                };
            } catch (Exception e) {
                print("Неверный выбор, попробуй снова.");
            }
        }
    }
}
