package game.gamestages.resultsEvaluator.bestHandsFinder;

import game.card.Card;
import game.card.Rank;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TempFindStraight {

    public int findIfThereIsStraight(Card[] cards) {

        int countOfSequencedCards = 0;

        List<Card> sortedCardList = Arrays
                .asList(cards)
                .stream()
                .sorted((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank())))
                .collect(Collectors.toList());

        Set<Rank> set = new HashSet<>(sortedCardList.size());
        sortedCardList.removeIf(p -> !set.add(p.getRank()));

        Object[] sortedCards = sortedCardList.toArray();

        int startingPositionOfStraight = 0;
        int amountOfSubsequentCards = 0;
        int largestAmountOfSubsequentCards = 0;

        for (int x = 0; x < sortedCards.length; x++) {

            if (x + 1 < cards.length
                    && RanksValue.rankValues.get(((Card) sortedCards[x]).getRank()) + 1 ==
                    RanksValue.rankValues.get(((Card) sortedCards[x + 1]).getRank())) {
                if (amountOfSubsequentCards == 0) {
                    startingPositionOfStraight = x;
                }
                countOfSequencedCards++;
            } else {
                if (amountOfSubsequentCards > largestAmountOfSubsequentCards) {
                    largestAmountOfSubsequentCards = amountOfSubsequentCards;
                }
            }
        }

        System.out.println(largestAmountOfSubsequentCards);

        return countOfSequencedCards;
    }

}
