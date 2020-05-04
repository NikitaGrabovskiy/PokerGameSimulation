package game.card.hands;

import game.card.Card;
import game.card.Rank;
import game.gameutil.FindPattern.ListComparator;
import game.gameutil.staticdata.RanksValue;

import java.util.List;

public class Pair implements Hand {

    private ListComparator listComparator;

    private static final int value = 2;

    private Rank rank;

    private List<Card> threeCards;

    public Pair(Rank rank,List<Card> threeCards){
        this.rank = rank;
        this.threeCards = threeCards;
        this.listComparator = new ListComparator();
    }

    public List<Card> getThreeCards() {
        return threeCards;
    }

    public int getValue() {
        return value;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Object o) {

        if(RanksValue.rankValues.get(this.rank)>RanksValue.rankValues.get(((Pair)o).getRank())){
            return 1;
        }else if(RanksValue.rankValues.get(this.rank)<RanksValue.rankValues.get(((Pair)o).getRank())){
            return -1;
        }else{
            int resultOfComparingTwoLists =listComparator.compareTwoCardLists(this.getThreeCards(),((Pair)o).getThreeCards());
            if(resultOfComparingTwoLists==1){
                return 1;
            }else if (resultOfComparingTwoLists==-1){
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Pair{" +
                rank +
                ", threeCards=" + threeCards +
                '}';
    }
}
