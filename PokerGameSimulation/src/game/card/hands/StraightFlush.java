package game.card.hands;

import game.card.Card;
import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;

public class StraightFlush implements Hand {

    private static final int value = 9;

    private Card[] cardsOfStraightFlush;

    public int getValue() {
        return value;
    }

    public StraightFlush(Card[] cardsOfStraightFlush){
        this.cardsOfStraightFlush = cardsOfStraightFlush;
    }

    public Card [] getCardsOfStraightFlush() {
        return cardsOfStraightFlush;
    }

    @Override
    public int compareTo(Object o) {

        Rank maxRankOfThisStraight = Arrays.asList(this.cardsOfStraightFlush)
                .stream()
                .max((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank())))
                .get().getRank();

        Rank maxRankOfOtherStraight = Arrays.asList(((StraightFlush) o).cardsOfStraightFlush)
                .stream()
                .max((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank())))
                .get().getRank();

        if(RanksValue.rankValues.get(maxRankOfThisStraight)>RanksValue.rankValues.get(maxRankOfOtherStraight)){
            return 1;
        }else if(RanksValue.rankValues.get(maxRankOfThisStraight)<RanksValue.rankValues.get(maxRankOfOtherStraight)){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "STRAIGHT FLUSH";
    }
}
