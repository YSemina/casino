package y.semina.service.impl;

import y.semina.model.Player;
import y.semina.service.PlayerService;

import static y.semina.util.ConsoleUtils.print;
import static y.semina.util.ConsoleUtils.registerPlayerMenu;

public class PlayerServiceImpl implements PlayerService {
    @Override
    public Player registerPlayer() {
        String name = registerPlayerMenu();
        Player player = new Player(name);
        print(player.getName() + ", добро пожаловать в казино!");
        return player;
    }
}
