package y.semina.strategy.blackjack;

import y.semina.model.Card;
import y.semina.strategy.GameStrategy;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.print;
import static y.semina.util.ConsoleUtils.printChoiceMenu;

/**
 * Реализация игры в блэкджек.
 * Игрок соревнуется с дилером, набирая сумму очков карт, не превышающую 21.
 */
public class BlackjackStrategy implements GameStrategy {
    private final Deck deck;
    private BigDecimal winnings;
    private int dealerScore;
    private int playerScore;

    private static final int BLACKJACK = 21;
    private static final int MAGIC_NUMBER_FOR_DEALER = 14;

    private static final BigDecimal BLACKJACK_MULTIPLY = BigDecimal.valueOf(3);
    private static final BigDecimal WIN_MULTIPLY = BigDecimal.valueOf(2);

    /**
     * Конструктор. Создаёт новую колоду и обнуляет выигрыш.
     */
    public BlackjackStrategy() {
        deck = new Deck();
        winnings = BigDecimal.ZERO;
    }

    /**
     * Проводит партию в блэкджек: раздаёт карты, обрабатывает решение игрока,
     * определяет победителя и возвращает выигрыш.
     *
     * @param betAmount сумма ставки
     * @return выигрыш (умножается на 2 при обычной победе, на 3 при блэкджеке)
     */
    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        dealerScore += showCardAndGetScore("Карта дилера:");
        playerScore += showCardAndGetScore("Твоя карта:");
        playerScore += showCardAndGetScore("Твоя карта:");

        if (isBlackJack(playerScore)) {
            return calculateWinningsAndShowInfo(betAmount, true);
        }

        showScore();

        boolean flag = true;
        while (flag) {
            if (isNeededCard()) {
                playerScore += showCardAndGetScore("Твоя карта:");
                if (playerScore > BLACKJACK) {
                    return showLose(false);
                } else if (isBlackJack(playerScore)) {
                    return calculateWinningsAndShowInfo(betAmount, true);
                }
                showScore();
            } else
                flag = false;
        }
        while (dealerScore < MAGIC_NUMBER_FOR_DEALER) {
            dealerScore += showCardAndGetScore("Карта дилера:");
        }

        if (dealerScore == BLACKJACK) {
            return showLose(true);
        } else if (dealerScore < playerScore || dealerScore > BLACKJACK)
            return calculateWinningsAndShowInfo(betAmount, false);
        else if (dealerScore > playerScore)
            return showLose(false);
        else //if (dealerScore == playerScore)
        {
            winnings = betAmount;
            showInfo(false);
            return winnings;
        }
    }

    /**
     * Запрашивает у игрока, нужно ли взять ещё карту.
     *
     * @return true если игрок хочет взять карту, false если останавливается
     */
    private boolean isNeededCard() {
        int playerNumber = printChoiceMenu(
                "\nЕщё карту?"
                        + "\n0 - да"
                        + "\n1 - нет");
        if (playerNumber < 0 || playerNumber > 1) {
            print("Нужно ввести 0 или 1");
            return isNeededCard();
        } else return playerNumber != 1;
    }

    /**
     * Рассчитывает выигрыш и выводит информацию о результате.
     *
     * @param betAmount сумма ставки
     * @param blackjack true если победный блэкджек (выигрыш ×3), иначе обычная победа (×2)
     * @return рассчитанный выигрыш
     */
    private BigDecimal calculateWinningsAndShowInfo(BigDecimal betAmount, boolean blackjack) {
        BigDecimal multiply;
        multiply = blackjack ? BLACKJACK_MULTIPLY : WIN_MULTIPLY;
        winnings = betAmount.multiply(multiply);
        showInfo(blackjack);
        return winnings;
    }

    /**
     * Выдаёт одну карту из колоды.
     *
     * @return следующая карта
     */
    private Card dealCard() {
        return deck.pollCard();
    }

    /**
     * Выводит сообщение, берёт карту из колоды и возвращает её очки.
     *
     * @param text сообщение перед показом карты
     * @return числовое значение карты
     */
    private int showCardAndGetScore(String text) {
        print(text);
        Card card = dealCard();
        System.out.println(card);
        return card.cardValue().getValue();
    }

    /**
     * Проверяет, набрано ли 21 очко.
     *
     * @param score текущая сумма очков
     * @return true если сумма равна 21
     */
    private boolean isBlackJack(int score) {
        return score == BLACKJACK;
    }

    /**
     * Выводит текущий счёт дилера и игрока.
     */
    private void showScore() {
        print("Счёт дилера: " + dealerScore);
        print("Твой счёт: " + playerScore);
    }

    /**
     * Выводит сумму выигрыша (с сообщением BLACKJACK при необходимости).
     *
     * @param blackjack true если выигрыш получен блэкджеком
     */
    private void showWinnings(boolean blackjack) {
        if (blackjack) print("BLACKJACK!!!");
        print("Твой выигрыш : " + winnings);
    }

    /**
     * Обрабатывает проигрыш и выводит информацию.
     *
     * @param blackjack true если проигрыш при блэкджеке у дилера
     * @return выигрыш (0 при проигрыше)
     */
    private BigDecimal showLose(boolean blackjack) {
        showInfo(blackjack);
        return winnings;
    }

    /**
     * Выводит полную информацию о результате игры (счёт и выигрыш).
     *
     * @param blackjack true если был блэкджек
     */
    private void showInfo(boolean blackjack) {
        showScore();
        showWinnings(blackjack);
    }
}
