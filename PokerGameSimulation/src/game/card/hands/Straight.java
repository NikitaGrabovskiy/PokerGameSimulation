package game.card.hands;

import game.card.Card;
import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;

public class Straight implements Hand {

    private static final int value = 5;

    private Card[] cardsOfStraightHand;


    public int getValue() {
        return value;
    }

    public Straight(Card[] cardsOfStraightHand){
        this.cardsOfStraightHand = cardsOfStraightHand;
    }


    public Card [] getCardsOfStraightHand() {
        return cardsOfStraightHand;
    }

    @Override
    public int compareTo(Object o) {

        Rank maxRankOfThisStraight = Arrays.asList(this.cardsOfStraightHand)
                .stream()
                .max((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank())))
                .get().getRank();

        Rank maxRankOfOtherStraight = Arrays.asList(((Straight) o).cardsOfStraightHand)
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
        return "Straight{ " +
                 Arrays.toString(cardsOfStraightHand) +
                " }";
    }
}
