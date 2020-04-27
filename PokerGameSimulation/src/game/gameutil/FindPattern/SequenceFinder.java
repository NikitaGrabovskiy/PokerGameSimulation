package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceFinder {




    // Finish This class later






 /*   public int findIfThereIsSequenceInTheGivenCards(Rank rank, Card[] cards
            ,int minimalSequenceNumberToLook) {

        int countOfSequencedCards = 0;

        List<Card> sortedCardList = Arrays
                .asList(cards)
                .stream()
                .sorted((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank()))).collect(Collectors.toList());

        Object[] sortedCards = sortedCardList.toArray();






        for (int x = 0; x < sortedCards.length; x++) {

            if (((Card)sortedCards[x]).getRank().equals(rank)
                    && x + 1 < cards.length
                    && RanksValue.rankValues.get(((Card) sortedCards[x]).getRank())+1==
                    RanksValue.rankValues.get(((Card) sortedCards[x+1]).getRank())) {
                countOfSequencedCards++;
            }
        }
        return countOfSequencedCards;
    }
*/

}
