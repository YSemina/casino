package y.semina;

import y.semina.factory.GameFactory;
import y.semina.model.Player;
import y.semina.service.CasinoService;
import y.semina.service.PlayerService;
import y.semina.service.impl.CasinoServiceImpl;
import y.semina.service.impl.PlayerServiceImpl;

import static y.semina.util.ConsoleUtils.askToExitMenu;

/**
 * Главный класс приложения. Запускает игровой процесс.
 */
public class Application {
    /**
     * Точка входа в программу. Регистрирует игрока и запускает цикл игр.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        CasinoService casinoService = new CasinoServiceImpl();
        PlayerService playerService = new PlayerServiceImpl();
        Player player = playerService.registerPlayer();

        do {
            casinoService.playGame(player, GameFactory.createGame());
        } while (!askToExitMenu());
    }
}
