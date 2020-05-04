package game.gameutil.staticdata;

import game.card.Rank;
import game.card.Suit;

import java.util.HashMap;
import java.util.Map;

public class CardSymbols {
    public static final Map<Rank,String> rankSymbols = new HashMap();
    public static final Map<Suit,String> suitSymbols = new HashMap();
    static{
        rankSymbols.put(Rank.TWO,"2");
        rankSymbols.put(Rank.THREE,"3");
        rankSymbols.put(Rank.FOUR,"4");
        rankSymbols.put(Rank.FIVE,"5");
        rankSymbols.put(Rank.SIX,"6");
        rankSymbols.put(Rank.SEVEN,"7");
        rankSymbols.put(Rank.EIGHT,"8");
        rankSymbols.put(Rank.NINE,"9");
        rankSymbols.put(Rank.TEN,"10");
        rankSymbols.put(Rank.JACK,"J");
        rankSymbols.put(Rank.QUEEN,"Q");
        rankSymbols.put(Rank.KING,"K");
        rankSymbols.put(Rank.ACE,"A");

        suitSymbols.put(Suit.CLUBS,"♣");
        suitSymbols.put(Suit.DIAMONDS,"♦");
        suitSymbols.put(Suit.HEARTS,"♥");
        suitSymbols.put(Suit.SPADES,"♠");
    }
}
