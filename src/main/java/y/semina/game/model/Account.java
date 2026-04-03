package y.semina.game.model;

import java.math.BigDecimal;

import static y.semina.game.util.Util.printChoice;

public class Account {

    private BigDecimal amountAccount;

    private static final int DEFAULT_AMOUNT = 1000;
    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 10000;

    public Account() {
        amountAccount = BigDecimal.valueOf(DEFAULT_AMOUNT);
        System.out.println("Создан счёт, начальный баланс - " + DEFAULT_AMOUNT);
    }

    public BigDecimal getAmountAccount() {
        return amountAccount;
    }

    public void deposit(BigDecimal amount) {
        amountAccount = amountAccount.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(amountAccount) <= 0) {
            amountAccount = amountAccount.subtract(amount);
        } else {
            System.out.println("Недостаточно средств на счёте для списания. Доступно " + amountAccount);
            if (isDeposit()) {
                withdraw(amount);
            } else
                withdraw(BigDecimal.ZERO);
        }
    }

    private boolean isDeposit() {
        int playerChoice = printChoice("Пополнить?\n0 - нет\n1 - да");
        if (playerChoice < 0 || playerChoice > 1) {
            System.out.println("Выбери 0 или 1");
            return isDeposit();
        }
        if (playerChoice == 1) {
            depositMenu();
            return true;
        }
        return false;
    }

    private void depositMenu() {
        int amount = printChoice("Введи сумму для пополнения счета от " + MIN_AMOUNT + " до " + MAX_AMOUNT);
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT)
            depositMenu();
        deposit(BigDecimal.valueOf(amount));
    }

}
