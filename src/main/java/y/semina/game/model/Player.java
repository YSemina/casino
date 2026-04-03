package y.semina.game.model;

import y.semina.game.util.Util;

import java.math.BigDecimal;

public class Player {

    private final String name;
    private final Account account;

    public Player(String name) {
        this.name = name;
        account = new Account();
    }

    public String getName() {
        return name;
    }

    public BigDecimal makeBet() {
        BigDecimal betAmount = Util.makeBet();
        account.withdraw(betAmount);
        System.out.println("С баланса списано " + betAmount);
        System.out.println("Текущий баланс - " + getBalance());
        return betAmount;
    }

    public void deposit(BigDecimal amount) {
        account.deposit(amount);
        System.out.println("Баланс пополнен на " + amount);
        System.out.println("Текущий баланс - " + getBalance());
    }

    public BigDecimal getBalance() {
        return account.getAmountAccount();
    }

}
