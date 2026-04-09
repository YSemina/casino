package y.semina.service.impl;

import y.semina.exception.NotEnoughMoneyException;
import y.semina.model.Player;
import y.semina.service.CasinoService;
import y.semina.strategy.GameStrategy;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.print;
import static y.semina.util.ConsoleUtils.printChoiceMenu;

public class CasinoServiceImpl implements CasinoService {
    @Override
    public void playGame(Player player, GameStrategy gameStrategy) {
        if (gameStrategy == null)
            throw new NullPointerException("Значение не может быть null");
        BigDecimal winnings;
        try {
            winnings = gameStrategy.playGame(player.makeBet());
        } catch (NotEnoughMoneyException ex) {
            print("Недостаточно денег для ставки");
            return;
        }
        if (winnings.compareTo(BigDecimal.ZERO) > 0)
            player.deposit(winnings);
        int playerChoice = printChoiceMenu(
                "На твоем счету " + player.getBalance() +
                        ". Хочешь пополнить?\n0 - да\n1 - нет");
        if (playerChoice == 0) {
            int amount = printChoiceMenu("Введи сумму для пополнения: ");
            player.deposit(BigDecimal.valueOf(amount));
        }
    }
}
