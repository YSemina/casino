package y.semina.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Set;

/**
 * Цвета ячеек рулетки (чёрный и красный).
 * Содержит набор номеров, соответствующих каждому цвету.
 */
@RequiredArgsConstructor
@Getter
public enum RouletteCellColorType {
    BLACK("чёрный", Set.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35)),
    RED("красный", Set.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));

    private final String name;
    private final Set<Integer> numbers;

    /**
     * Возвращает цвет по номеру ячейки рулетки.
     *
     * @param number номер от 1 до 36
     * @return цвет (чёрный или красный)
     * @throws IllegalArgumentException если номер не соответствует ни одному цвету
     */
    public static RouletteCellColorType fromValue(int number) {
        return Arrays.stream(values())
                .filter(color -> color.numbers.contains(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Нет номера " + number));
    }
}
