package game.card.hands;

import game.card.Card;
import game.gameutil.FindPattern.ListComparator;

import java.util.Arrays;

public class Flush implements Hand {


    private ListComparator listComparator;

    private static final int value = 6;

    private Card[] cardsOfFlush;

    public Flush(Card [] cards){
        this.cardsOfFlush = cards;
        this.listComparator = new ListComparator();
    }

    public int getValue() {
        return value;
    }

    public Card [] getCardsOfFlush() {
    return cardsOfFlush;
    }

    @Override
    public String toString() {
        return "FLUSH";
    }

    @Override
    public int compareTo(Object o) {
        int resultOfComparingTwoLists =listComparator.compareTwoCardLists(Arrays.asList(this.cardsOfFlush),Arrays.asList(((Flush)o).getCardsOfFlush()));
        if(resultOfComparingTwoLists==1){
            return 1;
        }else if (resultOfComparingTwoLists==-1){
            return -1;
        }

        return 0;
    }
}
