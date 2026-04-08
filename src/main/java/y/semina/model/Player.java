package y.semina.model;

import lombok.Getter;
import y.semina.exception.NotEnoughMoneyException;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.makeBetMenu;

/**
 * Игрок казино. Содержит имя и игровой счёт.
 */
@Getter
public class Player {
    private final String name;
    private final Account account;

    public Player(String name) {
        this.name = name;
        account = new Account();
    }

    public BigDecimal makeBet() {
        BigDecimal betAmount = makeBetMenu();
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
