package y.semina.model;

import y.semina.model.enums.CardValue;
import y.semina.model.enums.Suit;

/**
 * Запись, представляющая игральную карту.
 * Содержит значение карты и масть.
 *
 * @param cardValue значение карты (от двойки до туза)
 * @param suit      масть карты (крести, черви, буби, пики)
 */
public record Card(CardValue cardValue, Suit suit) {
    @Override
    public String toString() {
        return "_______________" +
                "\n|             |" +
                "\n|             |" +
                "\n     " + cardValue +
                "\n|             |" +
                "\n    " + suit +
                "\n|             |" +
                "\n|             |" +
                "\n_______________";
    }
}
