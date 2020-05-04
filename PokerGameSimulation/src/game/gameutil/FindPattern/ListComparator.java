package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

import java.util.List;

public class ListComparator {
    public int compareTwoCardLists(List<Card> listOne, List<Card> listTwo ) {
        for (int x = 0; x < listOne.size(); x++) {
            Rank maxRankOfFirstHighCardHand = findLargestRankInHighCardHand(listOne);
            Rank maxRankOfSecondHighCardHand = findLargestRankInHighCardHand(listTwo);
            if (RanksValue.rankValues.get(maxRankOfFirstHighCardHand) > RanksValue.rankValues.get(maxRankOfSecondHighCardHand)) {
                return 1;
            } else if (RanksValue.rankValues.get(maxRankOfFirstHighCardHand) < RanksValue.rankValues.get(maxRankOfSecondHighCardHand)){
                return -1;
            } else {
                listOne.removeIf(a->a.getRank().equals(maxRankOfFirstHighCardHand));
                listTwo.removeIf(a->a.getRank().equals(maxRankOfSecondHighCardHand));
            }
        }
        return 0;
    }
    private Rank findLargestRankInHighCardHand(List<Card> cardList){

       if(cardList.size()==0){
           System.out.println("LIST IS EMPTY");
       }
        return cardList
                .stream()
                .max((a, b) -> RanksValue.rankValues.get(b.getRank()).compareTo(RanksValue.rankValues.get(a.getRank())))
                .get()
                .getRank();
    }
}
