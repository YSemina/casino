package y.semina.service;

import y.semina.model.Player;

import java.math.BigDecimal;

import static y.semina.util.ConsoleUtils.print;

/**
 * Сервис для работы с игроком.
 */
public interface PlayerService {
    /**
     * Регистрирует нового игрока.
     *
     * @return зарегистрированный игрок
     */
    Player registerPlayer();
}
