package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Rank;
import game.card.hands.Straight;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SequenceFinder {

    public Straight findIfThereIsStraight(Card[] cards) {

        List<Card> sortedCardList = Arrays
                .asList(cards)
                .stream()
                .sorted((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank())))
                .collect(Collectors.toList());

        Set<Rank> set = new HashSet<>(sortedCardList.size());
        sortedCardList.removeIf(p -> !set.add(p.getRank()));

        Object[] sortedCards = sortedCardList.toArray();


       // System.out.println(sortedCardList);


        //Starts from largest card
        int beginningOfTheStraight = 0;

        // This count like this - 1 mean - 1 sequence - means 2 cards sequenced  and so on ...
        int amountOfSubsequentCards = 0;

        int largestAmountOfSubsequentCards = 0;

        for (int x = sortedCards.length - 1; x >= 0; x--) {

            if (largestAmountOfSubsequentCards == 4) {
                continue;
            }

            if (largestAmountOfSubsequentCards == 3 &&  RanksValue.rankValues.get(((Card) sortedCards[x]).getRank())==2) {
                beginningOfTheStraight =3;
                continue;
            }

            if (x - 1 >= 0
                    && (RanksValue.rankValues.get(((Card) sortedCards[x]).getRank()) - 1 ==
                    RanksValue.rankValues.get(((Card) sortedCards[x - 1]).getRank()))) {

                amountOfSubsequentCards++;
                if(beginningOfTheStraight==0){
                    beginningOfTheStraight=x;
                }

                if (amountOfSubsequentCards > largestAmountOfSubsequentCards) {
                    largestAmountOfSubsequentCards = amountOfSubsequentCards;
                }

            } else {
                amountOfSubsequentCards = 0;
                beginningOfTheStraight = 0;
            }

          //  System.out.println(largestAmountOfSubsequentCards);
           // System.out.println(beginningOfTheStraight);

        }

        Straight straight = null;


        if (largestAmountOfSubsequentCards == 4) {
            straight = new Straight(new Card[]{(Card) sortedCards[beginningOfTheStraight],
                    (Card) sortedCards[beginningOfTheStraight -1],
                    (Card) sortedCards[beginningOfTheStraight -2],
                    (Card) sortedCards[beginningOfTheStraight -3],
                    (Card) sortedCards[beginningOfTheStraight -4]});
        }


        if (largestAmountOfSubsequentCards == 3
                && (RanksValue.rankValues.get(((Card) sortedCards[0]).getRank())) == 2
                && Arrays.asList(cards)
                .stream()
                .filter((Card a) -> a.getRank().equals(Rank.ACE))
                .findAny()
                .isPresent()) {


            Card ace = Arrays.asList(cards)
                    .stream()
                    .filter((Card a) -> a.getRank().equals(Rank.ACE))
                    .findAny()
                    .get();

            straight = new Straight(
                    new Card[]{ace,
                    (Card) sortedCards[beginningOfTheStraight-3],
                    (Card) sortedCards[beginningOfTheStraight-2],
                    (Card) sortedCards[beginningOfTheStraight-1],
                    (Card) sortedCards[beginningOfTheStraight]});
        }


        return straight;
    }

}
