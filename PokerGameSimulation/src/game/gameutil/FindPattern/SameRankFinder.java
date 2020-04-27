package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Rank;

public class SameRankFinder {

    public int findNumberOfCardsOfGivenRank(Rank rank, Card[] cards){
        int countOfSameRankCards = 0;

        for (int x = 0; x < cards.length; x++) {
            if (cards[x].getRank().equals(rank)) {
                countOfSameRankCards++;
            }
        }
        return countOfSameRankCards;

    }
}
