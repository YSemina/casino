package y.semina.game.model;

import y.semina.exception.NotEnoughMoneyException;
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
        if (account.withdraw(betAmount))
            return betAmount;
        else
            throw new NotEnoughMoneyException("Недостаточно денег для ставки");
    }

    public void deposit(BigDecimal amount) {
        account.deposit(amount);
    }

    public BigDecimal getBalance() {
        return account.getAmountAccount();
    }

}
