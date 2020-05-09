package game.card.hands;

import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

public class FourOfAKind implements Hand{

    private static final int value = 8;

    private Rank rank;

    public FourOfAKind(Rank rank){
        this.rank = rank;
    }


    public int getValue() {
        return value;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "FOUR OF A KIND";
    }

    @Override
    public int compareTo(Object o) {
        if(RanksValue.rankValues.get(this.rank)>RanksValue.rankValues.get(((FourOfAKind)o).getRank())){
            return 1;
        }else if(RanksValue.rankValues.get(this.rank)<RanksValue.rankValues.get(((FourOfAKind)o).getRank())){
            return -1;
        }
        return 0;
    }
}
