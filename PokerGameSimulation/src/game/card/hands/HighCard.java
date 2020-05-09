package game.card.hands;

import game.card.Card;
import game.gameutil.FindPattern.ListComparator;

import java.util.Arrays;
import java.util.List;


public class HighCard implements Hand {

    private ListComparator listComparator;

    private static final int value = 1;
    private List<Card> fiveCards;

    public HighCard(List<Card> fiveCards) {
        this.fiveCards = fiveCards;
        this.listComparator = new ListComparator();
    }

    public List<Card> getFiveCards() {
        return fiveCards;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        int resultOfComparingTwoLists =listComparator.compareTwoCardLists(this.fiveCards,((HighCard)o).fiveCards);
        if(resultOfComparingTwoLists==1){
            return 1;
        }else if (resultOfComparingTwoLists==-1){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "HIGH CARD";
    }
}
