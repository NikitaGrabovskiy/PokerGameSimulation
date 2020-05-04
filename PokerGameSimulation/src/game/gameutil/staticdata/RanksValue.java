package game.gameutil.staticdata;

import game.card.Rank;

import java.util.HashMap;
import java.util.Map;

public class RanksValue {

    public static final Map<Rank,Integer> rankValues = new HashMap();

   // public static final Map<Integer,Rank> rankValuesForStraight = new HashMap();

    static {

        rankValues.put(Rank.TWO,2);
        rankValues.put(Rank.THREE,3);
        rankValues.put(Rank.FOUR,4);
        rankValues.put(Rank.FIVE,5);
        rankValues.put(Rank.SIX,6);
        rankValues.put(Rank.SEVEN,7);
        rankValues.put(Rank.EIGHT,8);
        rankValues.put(Rank.NINE,9);
        rankValues.put(Rank.TEN,10);
        rankValues.put(Rank.JACK,11);
        rankValues.put(Rank.QUEEN,12);
        rankValues.put(Rank.KING,13);
        rankValues.put(Rank.ACE,14);

    }
}
