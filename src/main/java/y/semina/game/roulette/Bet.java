package y.semina.game.roulette;

public enum Bet {

    STRAIGHT_BET,   //прямая ставка - на один номер
    SPLIT,          //на два соседних номера
    STRAIGHT,       //на три номера
    SQUARE,         //каре - на 4 номера
    SIXLINE,        //на 6 номеров
    EVEN,           //четный
    ODD,            //нечетный
    BLACK,
    RED;

    private static final Bet[] VALUES = values();

    public static Bet fromValue(int number) {
        if (number < 0 || number >= VALUES.length)
            throw new IllegalArgumentException("Допустимые значения - от 0 до " + (VALUES.length - 1));
        return VALUES[number];
    }

    public static int getCountBets() {
        return VALUES.length;
    }

}
