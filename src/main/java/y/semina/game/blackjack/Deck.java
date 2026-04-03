package y.semina.game.blackjack;

import y.semina.exception.DeckIsEmptyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = shuffleDeck(initDeck());
    }

    public Card pollCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        throw new DeckIsEmptyException("Колода закончилась");
    }

    private List<Card> initDeck() {
        List<Card> deck = new LinkedList<>();

        List<CardValue> cardValues = new ArrayList<>(Arrays.asList(CardValue.values()));
        List<Suit> suits = new ArrayList<>(Arrays.asList(Suit.values()));

        int countCardValue = cardValues.size();

        for (Suit suit : suits) {
            for (int j = 0; j < countCardValue; j++) {
                deck.add(new Card(cardValues.get(j), suit));
            }
        }
        return deck;
    }

    private List<Card> shuffleDeck(List<Card> deck) {
        int deckSize = deck.size();
        int remainingSize = deck.size();
        List<Card> shuffledDeck = new ArrayList<>(deckSize);
        Random random = new Random();
        for (int i = 0; i < deckSize; i++) {
            int indexForShuffle = random.nextInt(remainingSize);
            shuffledDeck.add(deck.remove(indexForShuffle));
            remainingSize--;
        }
        return shuffledDeck;
    }

    @Override
    public String toString() {
        return cards.toString();
    }

}
