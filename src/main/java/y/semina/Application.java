package y.semina;

import y.semina.game.Game;
import y.semina.service.CasinoService;
import y.semina.service.CasinoServiceImpl;

import static y.semina.game.util.Util.exit;

public class Application {

    public static void main(String[] args) {
        CasinoService service = new CasinoServiceImpl();
        Game game;
        service.registerPlayer();
        boolean flag = true;
        while (flag) {
            game = service.choiceGame();
            if (game == null) {
                break;
            }
            service.playGame(game);
            if (exit())
                flag = false;

        }
    }

}
