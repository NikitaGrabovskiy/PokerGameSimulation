package game.card.hands;

import game.card.Card;
import game.card.Rank;
import game.gameutil.FindPattern.ListComparator;
import game.gameutil.staticdata.RanksValue;


public class TwoPairs implements Hand {


    private ListComparator listComparator;

    public static final int value = 3;

    private Card fifthCard;
    private Rank rankOfFirstPair;
    private Rank rankOfSecondPair;

    public TwoPairs(Rank rankOfFirstPair, Rank rankOfSecondPair, Card fifthCard) {
        this.rankOfFirstPair = rankOfFirstPair;
        this.rankOfSecondPair = rankOfSecondPair;
        this.fifthCard = fifthCard;
        this.listComparator = new ListComparator();
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {

        System.out.println("Other hand is " + o);

        if (RanksValue.rankValues.get(this.rankOfFirstPair) > RanksValue.rankValues.get(((TwoPairs) o).rankOfFirstPair)) {
            return 1;
        } else if (RanksValue.rankValues.get(this.rankOfFirstPair) < RanksValue.rankValues.get(((TwoPairs) o).rankOfFirstPair)) {
            return -1;
        } else {
            if (RanksValue.rankValues.get(this.rankOfSecondPair) > RanksValue.rankValues.get(((TwoPairs) o).rankOfSecondPair)) {
                return 1;
            } else if (RanksValue.rankValues.get(this.rankOfSecondPair) < RanksValue.rankValues.get(((TwoPairs) o).rankOfSecondPair)) {
                return -1;
            } else {
                if (RanksValue.rankValues.get(this.fifthCard.getRank())
                        > RanksValue.rankValues.get(
                                ((TwoPairs) o).fifthCard.getRank())) {
                    return 1;
                } else if (RanksValue.rankValues.get(this.fifthCard.getRank()) < RanksValue.rankValues.get(((TwoPairs) o).fifthCard.getRank())) {
                    return -1;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "TwoPairs{" +
                ", rankOfFirstPair=" + rankOfFirstPair +
                ", rankOfSecondPair=" + rankOfSecondPair +
                "fifthCard=" + fifthCard +
                '}';
    }
}
