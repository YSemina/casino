package y.semina.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Типы игр, доступные в программе.
 */
@RequiredArgsConstructor
@Getter
public enum GameType {
    ROULETTE(0, "рулетка"),
    BLACKJACK(1, "блекджек");

    private final int id;
    private final String typeName;

    /**
     * Возвращает тип игры по числовому выбору пользователя.
     *
     * @param gameChoice число (0 или 1)
     * @return соответствующий тип игры
     * @throws IllegalArgumentException если число не соответствует ни одному типу
     */
    public static GameType fromPlayerChoice(int gameChoice) {
        return Arrays.stream(values())
                .filter(type -> type.id == gameChoice)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown gameChoice: " + gameChoice));
    }
}
