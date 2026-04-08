package y.semina.service;

import y.semina.model.Player;
import y.semina.strategy.GameStrategy;

/**
 * Сервис для управления игровым процессом в казино.
 */
public interface CasinoService {
    /**
     * Запускает игру для игрока с использованием указанной стратегии.
     *
     * @param player       игрок
     * @param gameStrategy стратегия игры
     */
    void playGame(Player player, GameStrategy gameStrategy);
}
