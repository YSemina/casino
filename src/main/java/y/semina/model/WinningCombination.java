package y.semina.model;

import y.semina.model.enums.RouletteCellColorType;

/**
 * Запись, представляющая выигрышную комбинацию в рулетке.
 * Содержит номер ячейки и её цвет.
 *
 * @param number выигрышный номер (от 1 до 36)
 * @param rouletteCellColorType  цвет выигрышной ячейки (чёрный или красный)
 */
public record WinningCombination(int number, RouletteCellColorType rouletteCellColorType) {
}
