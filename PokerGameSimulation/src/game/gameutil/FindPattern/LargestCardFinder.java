package game.gameutil.FindPattern;

import game.card.Card;
import game.card.hands.HighCard;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestCardFinder {


    public HighCard findHighCardHand(Card[] cards) {

        List<Card> sortedCardList = Arrays
                .asList(cards)
                .stream()
                .sorted((a, b) -> RanksValue.rankValues.get(b.getRank()).compareTo(RanksValue.rankValues.get(a.getRank())))
                .collect(Collectors.toList());

        return new HighCard(sortedCardList.subList(0, 5));
    }


}
