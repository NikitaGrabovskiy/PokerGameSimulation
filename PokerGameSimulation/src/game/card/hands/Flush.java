package game.card.hands;

import game.card.Card;
import game.card.TwoCardsInPlayersHands;
import game.gameutil.FindPattern.ListComparator;

import java.util.Arrays;

public class Flush implements Hand {


    private ListComparator listComparator;

    private static final int value = 6;

    public void setCardsOfFlush(Card[] cardsOfFlush) {
        this.cardsOfFlush = cardsOfFlush;
        this.listComparator = new ListComparator();
    }

    private Card[] cardsOfFlush;

    public Flush(Card [] cards){
        this.cardsOfFlush = cards;
    }

    public int getValue() {
        return value;
    }

    public Card [] getCardsOfFlush() {
    return cardsOfFlush;
    }

    @Override
    public String toString() {
        return "Flush{" +
                Arrays.toString(cardsOfFlush) +
                '}';
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
