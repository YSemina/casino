package y.semina.game.blackjack;

import y.semina.game.Game;

import java.math.BigDecimal;

import static y.semina.game.util.Util.printChoice;

public class Blackjack implements Game {

    private final Deck deck;
    private BigDecimal winnings;
    private int dealerScore;
    private int playerScore;

    private static final int BLACKJACK = 21;
    private static final int MAGIC_NUMBER_FOR_DEALER = 14;

    private static final BigDecimal BLACKJACK_MULTIPLY = BigDecimal.valueOf(3);
    private static final BigDecimal WIN_MULTIPLY = BigDecimal.valueOf(2);

    public Blackjack() {
        deck = new Deck();
        winnings = BigDecimal.ZERO;
    }

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

    private boolean isNeededCard() {
        int playerNumber = printChoice("\nЕщё карту?"
                + "\n0 - да"
                + "\n1 - нет");
        if (playerNumber < 0 || playerNumber > 1) {
            System.out.println("Нужно ввести 0 или 1");
            return isNeededCard();
        } else return playerNumber != 1;
    }

    private BigDecimal calculateWinningsAndShowInfo(BigDecimal betAmount, boolean blackjack) {
        BigDecimal multiply;
        if (blackjack)
            multiply = BLACKJACK_MULTIPLY;
        else
            multiply = WIN_MULTIPLY;
        winnings = betAmount.multiply(multiply);
        showInfo(blackjack);
        return winnings;
    }

    private Card dealCard() {
        return deck.pollCard();
    }

    private int showCardAndGetScore(String text) {
        System.out.println(text);
        Card card = dealCard();
        System.out.println(card);
        return card.getCardValue().getValue();
    }

    private boolean isBlackJack(int score) {
        return score == BLACKJACK;
    }

    private void showScore() {
        System.out.println("Счёт дилера: " + dealerScore);
        System.out.println("Твой счёт: " + playerScore);
    }

    private void showWinnings(boolean blackjack) {
        if (blackjack)
            System.out.println("BLACKJACK!!!");
        System.out.println("Твой выигрыш : " + winnings);
    }

    private BigDecimal showLose(boolean blackjack) {
        showInfo(blackjack);
        return winnings;
    }

    private void showInfo(boolean blackjack) {
        showScore();
        showWinnings(blackjack);
    }

}
