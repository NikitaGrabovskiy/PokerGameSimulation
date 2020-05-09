package game.card.hands;

import game.card.Card;
import game.card.Rank;
import game.gameutil.FindPattern.ListComparator;
import game.gameutil.staticdata.RanksValue;

import java.util.List;

public class ThreeOfAKind implements Hand {

    private ListComparator listComparator;

    private static final int value = 4;

    private Rank rank;

    private List<Card> otherTwoCards;

    public ThreeOfAKind(Rank rank,List<Card> otherTwoCards){
        this.rank = rank;
        this.otherTwoCards = otherTwoCards;
        this.listComparator = new ListComparator();
    }

    public int getValue() {
        return value;
    }

    public Rank getRank() {
        return rank;
    }


    public List<Card> getOtherTwoCards() {
        return otherTwoCards;
    }

    @Override
    public int compareTo(Object o) {
        if(RanksValue.rankValues.get(this.rank)>RanksValue.rankValues.get(((ThreeOfAKind)o).getRank())){
            return 1;
        }else if(RanksValue.rankValues.get(this.rank)<RanksValue.rankValues.get(((ThreeOfAKind)o).getRank())){
            return -1;
        }else{
            int resultOfComparingTwoLists =listComparator.compareTwoCardLists(this.otherTwoCards,((ThreeOfAKind)o).getOtherTwoCards());
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
        return "THREE OF A KIND";
    }
}
