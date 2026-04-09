package y.semina.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Типы ставок в рулетке.
 */
@RequiredArgsConstructor
@Getter
public enum RouletteGameType {
    BET_STRAIGHT_ONE(0, "прямая ставка - на один номер"),   //прямая ставка - на один номер
    BET_SPLIT(1, "ставка на два соседних номера"),          //на два соседних номера
    BET_STRAIGHT_THREE(2, "ставка на три номер"),       //на три номера
    BET_SQUARE(3, "ставка на 4 номера (каре)"),         //каре - на 4 номера
    BET_SIX(4, "ставка на шесть номеров"),        //на 6 номеров
    BET_EVEN(5, "ставка на четные"),           //четный
    BET_ODD(6, "ставка на нечентые"),            //нечетный
    BET_BLACK(7, "ставка на черное"),
    BET_RED(8, "ставка на красное");

    private final int id;
    private final String typeName;

    /**
     * Возвращает тип ставки по числовому выбору пользователя.
     *
     * @param betChoice число от 0 до 8
     * @return соответствующий тип ставки
     * @throws IllegalArgumentException если число не соответствует ни одному типу
     */
    public static RouletteGameType fromBetChoice(int betChoice) {
        return Arrays.stream(values())
                .filter(type -> type.id == betChoice)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown betChoice: " + betChoice));
    }
}
