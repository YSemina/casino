package y.semina.game.util;

import java.math.BigDecimal;
import java.util.Scanner;

public class Util {

    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 2000;


    public static BigDecimal makeBet() {
        boolean flag = true;
        int usersAmount = 0;
        while (flag) {
            usersAmount = printChoice("Введи сумму ставки от " + MIN_AMOUNT + " до " + MAX_AMOUNT);
            if ((usersAmount >= MIN_AMOUNT) && (usersAmount <= MAX_AMOUNT))
                flag = false;
            else
                System.out.println("Нужно ввести значение ставки от " + MIN_AMOUNT + " до " + MAX_AMOUNT);
        }
        return BigDecimal.valueOf(usersAmount);
    }

    public static boolean exit() {
        System.out.println("Для выхода нажимай 0, для продолжения любую кнопку");
        int choice = new Scanner(System.in).nextInt();
        return choice == 0;
    }

    public static int printChoice(String text) {
        int number = -1;
        System.out.println(text);
        try {
            number = scanner().nextInt();
        } catch (Exception ex) {
            System.out.println("Нужно было ввести число");
        }
        return number;
    }

    private static Scanner scanner() {
        return new Scanner(System.in);
    }

}
