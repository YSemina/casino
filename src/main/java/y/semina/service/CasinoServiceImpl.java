package y.semina.service;

import y.semina.exception.NotEnoughMoneyException;
import y.semina.game.Game;
import y.semina.game.blackjack.Blackjack;
import y.semina.game.model.Player;
import y.semina.game.roulette.Roulette;

import java.math.BigDecimal;
import java.util.Scanner;

import static y.semina.game.util.Util.exit;
import static y.semina.game.util.Util.printChoice;

public class CasinoServiceImpl implements CasinoService {

    private Player player;

    @Override
    public Player registerPlayer() {
        System.out.println("Введи свое имя, чтобы начать играть:");
        String playerName = new Scanner(System.in).nextLine();
        player = new Player(playerName);
        System.out.println(player.getName() + ", добро пожаловать в казино!");
        return player;
    }

    @Override
    public Game choiceGame() {
        int playerChoice = printChoice("Выбери во что будешь играть:\n0 - рулетка\n1 - блекджек");
        switch (playerChoice) {
            case 0:
                return new Roulette();
            case 1:
                return new Blackjack();
        }
        if (!exit())
            choiceGame();
        return null;
    }

    @Override
    public void playGame(Game game) {
        if (game == null)
            throw new NullPointerException("Значение не может быть null");
        BigDecimal winnings = BigDecimal.ZERO;
        try {
            winnings = game.playGame(player.makeBet());
        } catch (NotEnoughMoneyException ex){
            System.out.println("Недостаточно денег для ставки");
            return;
        }
        if (winnings.compareTo(BigDecimal.ZERO) > 0)
            player.deposit(winnings);
        int playerChoice = printChoice("На твоем счету " + player.getBalance() +
                ". Хочешь пополнить?\n0 - да\n1 - нет");
        if (playerChoice == 0) {
            int amount = printChoice("Введи сумму для пополнения: ");
            player.deposit(BigDecimal.valueOf(amount));
        }
    }

}
