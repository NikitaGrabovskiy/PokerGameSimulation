package game.card.hands;

import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

public class ThreeOfAKind implements Hand {

    private static final int value = 4;

    private Rank rank;

    public ThreeOfAKind(Rank rank){
        this.rank = rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Object o) {
        if(RanksValue.rankValues.get(this.rank)>RanksValue.rankValues.get(((ThreeOfAKind)o).getRank())){
            return 1;
        }else if(RanksValue.rankValues.get(this.rank)<RanksValue.rankValues.get(((ThreeOfAKind)o).getRank())){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ThreeOfAKind{" +
                 rank +
                '}';
    }
}
