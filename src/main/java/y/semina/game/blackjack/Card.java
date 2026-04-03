package y.semina.game.blackjack;

public class Card {

    CardValue cardValue;
    Suit suit;

    public Card(CardValue cardValue, Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

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
                "\n_______________"
                ;
    }

}
