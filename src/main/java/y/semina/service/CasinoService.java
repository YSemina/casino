package y.semina.service;

import y.semina.game.Game;
import y.semina.game.model.Player;

public interface CasinoService {

    Player registerPlayer();
    Game choiceGame();
    void playGame(Game game);

}
