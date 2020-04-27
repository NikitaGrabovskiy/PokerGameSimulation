package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Suit;

public class SameSuitFinder {

    public int findNumberOfCardsOfGivenSuit(Suit suit, Card[] cards) {

        int countOfSameSuitCards = 0;

        for (int x = 0; x < cards.length; x++) {
            if (cards[x].getSuit().equals(suit)) {
                countOfSameSuitCards++;
            }
        }
        return countOfSameSuitCards;
    }


}
