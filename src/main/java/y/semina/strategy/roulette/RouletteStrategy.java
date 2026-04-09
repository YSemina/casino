package y.semina.strategy.roulette;

import y.semina.model.WinningCombination;
import y.semina.model.enums.RouletteCellColorType;
import y.semina.strategy.GameStrategy;

import java.util.Random;

import static y.semina.util.ConsoleUtils.print;

/**
 * Стратегия игры в рулетку. Содержит общие методы для всех типов ставок.
 */
public interface RouletteStrategy extends GameStrategy {
    /**
     * Вращает рулетку и возвращает выигрышную комбинацию.
     *
     * @return объект с выигрышным номером и цветом
     */
    default WinningCombination spinWheel() {
        int number = new Random().nextInt(36) + 1;
        RouletteCellColorType type = RouletteCellColorType.fromValue(number);
        print("Шарик на " + number + " " + type);
        return new WinningCombination(number, type);
    }
}
