package game.card.hands;

import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

public class FullHouse implements Hand {

    private static final int value = 7;

    private Rank rankOfTreeCards;

    private Rank rankOfTwoCards;

    public FullHouse(Rank rankOfTreeCards,Rank rankOfTwoCards){
        this.rankOfTreeCards=rankOfTreeCards;
        this.rankOfTwoCards=rankOfTwoCards;
    }

    public int getValue() {
        return value;
    }

    public Rank getRankOfTreeCards() {
        return rankOfTreeCards;
    }

    public Rank getRankOfTwoCards() {
        return rankOfTwoCards;
    }

    @Override
    public String toString() {
        return "FULL HOUSE";
    }

    @Override
    public int compareTo(Object o) {
            if(RanksValue.rankValues.get(this.rankOfTreeCards)>RanksValue.rankValues.get(((FullHouse)o).getRankOfTreeCards())){
                return 1;
            }else if(RanksValue.rankValues.get(this.rankOfTreeCards)<RanksValue.rankValues.get(((FullHouse)o).getRankOfTreeCards())){
                return -1;
            } else{
                if (RanksValue.rankValues.get(this.rankOfTwoCards) > RanksValue.rankValues.get(((FullHouse) o).rankOfTwoCards)) {
                    return 1;
                } else if (RanksValue.rankValues.get(this.rankOfTwoCards) < RanksValue.rankValues.get(((FullHouse) o).getRankOfTwoCards())) {
                    return -1;
                }
            }
        return 0;
    }
}
