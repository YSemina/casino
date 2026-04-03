package y.semina.game.roulette;

import y.semina.game.Game;

import java.math.BigDecimal;
import java.util.Random;

import static y.semina.game.util.Util.printChoice;

public class Roulette implements Game {

    private BigDecimal betAmount;

    private static final BigDecimal STRAIGHT_BET_MULTIPLY = BigDecimal.valueOf(35);
    private static final BigDecimal SPLIT_MULTIPLY = BigDecimal.valueOf(17);
    private static final BigDecimal STRAIGHT_MULTIPLY = BigDecimal.valueOf(11);
    private static final BigDecimal SQUARE_MULTIPLY = BigDecimal.valueOf(8);
    private static final BigDecimal SIXLINE_MULTIPLY = BigDecimal.valueOf(6);
    private static final BigDecimal EVEN_MULTIPLY = BigDecimal.valueOf(2);
    private static final BigDecimal ODD_MULTIPLY = BigDecimal.valueOf(2);
    private static final BigDecimal BLACK_MULTIPLY = BigDecimal.valueOf(2);
    private static final BigDecimal RED_MULTIPLY = BigDecimal.valueOf(2);

    @Override
    public BigDecimal playGame(BigDecimal betAmount) {
        Bet bet = choiceBet();
        this.betAmount = betAmount;
        BigDecimal winnings = BigDecimal.ZERO;
        switch (bet) {
            case STRAIGHT_BET:
                winnings = playStraightBet();
                break;
            case SPLIT:
                winnings = playSplit();
                break;
            case STRAIGHT:
                winnings = playStraight();
                break;
            case SQUARE:
                playSquare();
                break;
            case SIXLINE:
                playSixline();
                break;
            case EVEN:
                winnings = playEven();
                break;
            case ODD:
                winnings = playOdd();
                break;
            case BLACK:
                winnings = playBlack();
                break;
            case RED:
                winnings = playRed();
                break;
        }
        System.out.println("Твой выигрыш - " + winnings);
        return winnings;
    }

    private Bet choiceBet() {
        boolean flag = true;
        int usersBet = 0;
        final int FIRST_BET = 0;
        final int LAST_BET = Bet.getCountBets();
        while (flag) {
            usersBet = printChoice(
                    "Выбери ставку:\n" +
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
            if ((usersBet >= FIRST_BET) && (usersBet <= LAST_BET))
                flag = false;
            else
                System.out.println("Нужно ввести значение от " + FIRST_BET + " до " + LAST_BET +
                        ", которое соответсвует выбранной ставке");
        }
        return Bet.fromValue(usersBet);
    }

    private BigDecimal playStraightBet() {
        int usersNumber = printChoice("Введи число от 1 до 36");
        if (usersNumber < 1 || usersNumber > 36) {
            System.out.println("Нужно ввести число от 1 до 36");
            return playStraightBet();
        }
        int number = spinWheel().number();
        if (number == usersNumber) {
            return betAmount.multiply(STRAIGHT_BET_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal playSplit() {
        int[] usersNumber = new int[2];
        usersNumber[0] = printChoice("Введи число от 1 до 35. Второе число для ставки будет на 1 больше.");
        if (usersNumber[0] < 1 || usersNumber[0] > 35) {
            System.out.println("Нужно ввести число от 1 до 35");
            return playSplit();
        }
        usersNumber[1] = usersNumber[0] + 1;
        int number = spinWheel().number();
        if (number == usersNumber[0] || number == usersNumber[1]) {
            return betAmount.multiply(SPLIT_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal playStraight() {
        int[] usersNumber = new int[3];
        usersNumber[0] = printChoice("Введи число от 1 до 34. " +
                "Второе и третье числа для ставки будет на 1 и 2 больше соответсвенно.");
        if (usersNumber[0] < 1 || usersNumber[0] > 34) {
            System.out.println("Нужно ввести число от 1 до 34");
            return playStraight();
        }
        usersNumber[1] = usersNumber[0] + 1;
        usersNumber[2] = usersNumber[0] + 2;
        int number = spinWheel().number();
        if (number == usersNumber[0] || number == usersNumber[1] || number == usersNumber[2]) {
            return betAmount.multiply(STRAIGHT_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private void playSquare() {
        System.out.println("Нет реализации");
    }

    private void playSixline() {
        System.out.println("Нет реализации");
    }

    private BigDecimal playEven() {
        int number = spinWheel().number();
        if (number % 2 == 0) {
            return betAmount.multiply(EVEN_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal playOdd() {
        int number = spinWheel().number();
        if (number % 2 != 0) {
            return betAmount.multiply(ODD_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal playBlack() {
        Color color = getColor();
        if (color.equals(Color.BLACK)) {
            return betAmount.multiply(BLACK_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal playRed() {
        Color color = getColor();
        if (color.equals(Color.RED)) {
            return betAmount.multiply(RED_MULTIPLY);
        }
        return BigDecimal.ZERO;
    }

    private Color getColor() {
        return spinWheel().color();
    }

    private WinningCombination spinWheel() {
        int number = new Random().nextInt(36) + 1;
        Color color = Color.fromValue(number);
        System.out.println("Шарик на " + number + " " + color);
        return new WinningCombination(number, color);
    }

}
