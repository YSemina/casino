package y.semina.strategy.blackjack;

import y.semina.exception.DeckIsEmptyException;
import y.semina.model.Card;
import y.semina.model.enums.CardValue;
import y.semina.model.enums.Suit;

import java.util.*;

/**
 * Колода игральных карт (52 карты, 4 масти по 13 значений).
 */
public class Deck {
    private final List<Card> cards;

    /**
     * Конструктор. Инициализирует и перемешивает колоду.
     */
    public Deck() {
        cards = shuffleDeck(initDeck());
    }

    /**
     * Извлекает и возвращает верхнюю карту из колоды.
     *
     * @return следующая карта
     * @throws DeckIsEmptyException если колода пуста
     */
    public Card pollCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        throw new DeckIsEmptyException("Колода закончилась");
    }

    /**
     * Создаёт новую колоду из 52 карт (все масти × все значения).
     *
     * @return список карт в исходном порядке
     */
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

    /**
     * Перемешивает колоду случайным образом.
     *
     * @param deck исходная колода (будет опустошена в процессе)
     * @return перемешанная колода
     */
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
}
