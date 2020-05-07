package game.gameutil;

import game.card.Card;
import game.card.Rank;
import game.card.ShuffledDeck;
import game.card.Suit;

import java.util.*;

public class DeckGenerator {

    private static Map<Integer, Card> notShuffledDeck = new HashMap();

    private Set<Integer> setOfUsedValues = new HashSet<>();

    static {
        notShuffledDeck.put(1, new Card(Rank.TWO, Suit.CLUBS));
        notShuffledDeck.put(2, new Card(Rank.THREE, Suit.CLUBS));
        notShuffledDeck.put(3, new Card(Rank.FOUR, Suit.CLUBS));
        notShuffledDeck.put(4, new Card(Rank.FIVE, Suit.CLUBS));
        notShuffledDeck.put(5, new Card(Rank.SIX, Suit.CLUBS));
        notShuffledDeck.put(6, new Card(Rank.SEVEN, Suit.CLUBS));
        notShuffledDeck.put(7, new Card(Rank.EIGHT, Suit.CLUBS));
        notShuffledDeck.put(8, new Card(Rank.NINE, Suit.CLUBS));
        notShuffledDeck.put(9, new Card(Rank.TEN, Suit.CLUBS));
        notShuffledDeck.put(10, new Card(Rank.JACK, Suit.CLUBS));
        notShuffledDeck.put(11, new Card(Rank.QUEEN, Suit.CLUBS));
        notShuffledDeck.put(12, new Card(Rank.KING, Suit.CLUBS));
        notShuffledDeck.put(13, new Card(Rank.ACE, Suit.CLUBS));

        notShuffledDeck.put(14, new Card(Rank.TWO, Suit.DIAMONDS));
        notShuffledDeck.put(15, new Card(Rank.THREE, Suit.DIAMONDS));
        notShuffledDeck.put(16, new Card(Rank.FOUR, Suit.DIAMONDS));
        notShuffledDeck.put(17, new Card(Rank.FIVE, Suit.DIAMONDS));
        notShuffledDeck.put(18, new Card(Rank.SIX, Suit.DIAMONDS));
        notShuffledDeck.put(19, new Card(Rank.SEVEN, Suit.DIAMONDS));
        notShuffledDeck.put(20, new Card(Rank.EIGHT, Suit.DIAMONDS));
        notShuffledDeck.put(21, new Card(Rank.NINE, Suit.DIAMONDS));
        notShuffledDeck.put(22, new Card(Rank.TEN, Suit.DIAMONDS));
        notShuffledDeck.put(23, new Card(Rank.JACK, Suit.DIAMONDS));
        notShuffledDeck.put(24, new Card(Rank.QUEEN, Suit.DIAMONDS));
        notShuffledDeck.put(25, new Card(Rank.KING, Suit.DIAMONDS));
        notShuffledDeck.put(26, new Card(Rank.ACE, Suit.DIAMONDS));

        notShuffledDeck.put(27, new Card(Rank.TWO, Suit.HEARTS));
        notShuffledDeck.put(28, new Card(Rank.THREE, Suit.HEARTS));
        notShuffledDeck.put(29, new Card(Rank.FOUR, Suit.HEARTS));
        notShuffledDeck.put(30, new Card(Rank.FIVE, Suit.HEARTS));
        notShuffledDeck.put(31, new Card(Rank.SIX, Suit.HEARTS));
        notShuffledDeck.put(32, new Card(Rank.SEVEN, Suit.HEARTS));
        notShuffledDeck.put(33, new Card(Rank.EIGHT, Suit.HEARTS));
        notShuffledDeck.put(34, new Card(Rank.NINE, Suit.HEARTS));
        notShuffledDeck.put(35, new Card(Rank.TEN, Suit.HEARTS));
        notShuffledDeck.put(36, new Card(Rank.JACK, Suit.HEARTS));
        notShuffledDeck.put(37, new Card(Rank.QUEEN, Suit.HEARTS));
        notShuffledDeck.put(38, new Card(Rank.KING, Suit.HEARTS));
        notShuffledDeck.put(39, new Card(Rank.ACE, Suit.HEARTS));

        notShuffledDeck.put(40, new Card(Rank.TWO, Suit.SPADES));
        notShuffledDeck.put(41, new Card(Rank.THREE, Suit.SPADES));
        notShuffledDeck.put(42, new Card(Rank.FOUR, Suit.SPADES));
        notShuffledDeck.put(43, new Card(Rank.FIVE, Suit.SPADES));
        notShuffledDeck.put(44, new Card(Rank.SIX, Suit.SPADES));
        notShuffledDeck.put(45, new Card(Rank.SEVEN, Suit.SPADES));
        notShuffledDeck.put(46, new Card(Rank.EIGHT, Suit.SPADES));
        notShuffledDeck.put(47, new Card(Rank.NINE, Suit.SPADES));
        notShuffledDeck.put(48, new Card(Rank.TEN, Suit.SPADES));
        notShuffledDeck.put(49, new Card(Rank.JACK, Suit.SPADES));
        notShuffledDeck.put(50, new Card(Rank.QUEEN, Suit.SPADES));
        notShuffledDeck.put(51, new Card(Rank.KING, Suit.SPADES));
        notShuffledDeck.put(52, new Card(Rank.ACE, Suit.SPADES));
    }


    public ShuffledDeck getNewShuffledDeck() {

        setOfUsedValues = new HashSet<>();
        Card[] cards = new Card[52];

        Random random = new Random();

        for (int x = 0; x < 52; x++) {

            int sizeOfSetOfUsedValues = setOfUsedValues.size();

            while (setOfUsedValues.size() == sizeOfSetOfUsedValues) {
                Integer cardNumber = new Integer(random.nextInt(52) + 1);
                if (setOfUsedValues.contains(cardNumber)) {
                    continue;
                } else {
                    setOfUsedValues.add(cardNumber);
                    cards[x] = notShuffledDeck.get(cardNumber);
                }
            }

        }

        checkIfAllCardsAreDifferentInTheShuffledDeck(cards);

        return new ShuffledDeck(cards);
    }

    private void checkIfAllCardsAreDifferentInTheShuffledDeck(Card[] cards) {
        if (cards.length != 52 || !(Arrays.asList(cards).stream().distinct().count() == 52)) {
            throw new IllegalArgumentException("THE DECK IS CREATED WITH ERROR !");
        }
    }

}
