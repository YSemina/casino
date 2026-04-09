package y.semina.util;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Утилитарный класс для работы с консольным вводом/выводом.
 * Содержит методы для чтения ставок, выбора пользователя и выхода из игры.
 */
@UtilityClass
public class ConsoleUtils {
    private static final int MIN_BET = 100;
    private static final int MAX_BET = 2000;
    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 10000;

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Запрашивает у пользователя сумму ставки в диапазоне от 100 до 2000.
     *
     * @return сумма ставки
     */
    public static BigDecimal makeBetMenu() {
        while (true) {
            print("Введи сумму ставки от " + MIN_BET + " до " + MAX_BET);
            int amount = readInt();
            if ((amount >= MIN_BET) && (amount <= MAX_BET))
                return BigDecimal.valueOf(amount);
            print("Ошибка: ставка должна быть от " + MIN_BET + " до " + MAX_BET);
        }
    }

    /**
     * Запрашивает у пользователя желание выйти из игры.
     *
     * @return true если пользователь ввёл 0 (выход), false иначе
     */
    public static boolean askToExitMenu() {
        print("Для выхода нажимай 0, для продолжения любую кнопку");
        return readInt() == 0;
    }

    /**
     * Запрашивает у пользователя желание выйти из игры.
     */
    public static boolean askToDepositMenu() {
        while (true) {
            int playerChoice = printChoiceMenu(
                    "Пополнить?" +
                            "\n0 - нет" +
                            "\n1 - да");

            if (playerChoice == 1) return true;

            print("Выбери 0 или 1");
        }
    }


    /**
     * Выводит текст и считывает целочисленный ввод пользователя.
     *
     * @param message сообщение для вывода
     * @return введённое число
     */
    public static int printChoiceMenu(String message) {
        print(message);
        return readInt();
    }

    public static String registerPlayerMenu() {
        print("Введи свое имя, чтобы начать играть:");
        return readLine();
    }

    /**
     * Меню пополнения счёта. Запрашивает сумму и пополняет.
     */
    public static BigDecimal depositMenu() {
        while (true) {
            print("Введи сумму для пополнения счета от " + MIN_AMOUNT + " до " + MAX_AMOUNT);
            int amount = readInt();
            if ((amount < MIN_AMOUNT || amount > MAX_AMOUNT))
                return BigDecimal.valueOf(amount);
            print("Ошибка: сумму для пополнения счета должна быть от " + MIN_AMOUNT + " до " + MAX_AMOUNT);
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static int readInt() {
        while (!scanner.hasNextInt()) {
            print("Нужно ввести число");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}
