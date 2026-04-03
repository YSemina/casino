package y.semina.game.roulette;

import java.util.Set;

public enum Color {

    BLACK, RED;

    private static final Set<Integer> RED_NUMBERS =
            Set.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);
    private static final Set<Integer> BLACK_NUMBERS =
            Set.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35);

    public static Color fromValue(int number) {
        if (RED_NUMBERS.contains(number)) return RED;
        if (BLACK_NUMBERS.contains(number)) return BLACK;
        throw new IllegalArgumentException("Нет номера " + number);
    }

    @Override
    public String toString() {
        return this == BLACK ? "чёрный" : "красный";
    }

}
