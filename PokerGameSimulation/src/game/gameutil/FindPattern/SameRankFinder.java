package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Rank;
import game.card.hands.*;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SameRankFinder {

    private Set<Rank> setOfFourValues = new HashSet();
    private Set<Rank> setOfThreeValues = new HashSet();
    private Set<Rank> setOfTwoValues = new HashSet();

    public Hand findBestSameRankCombination(Card[] cards) {

        addCardsToSetOfRepetitions(cards);

/*        System.out.println("Two values" + setOfTwoValues);
        System.out.println("Three values" + setOfThreeValues);
        System.out.println("Four values" + setOfFourValues);*/

        Hand bestSameRankHand = null;

        if (setOfFourValues.size() == 1) {
            bestSameRankHand = new FourOfAKind(setOfFourValues.stream().findAny().get());
        } else if (setOfThreeValues.size() == 2) {
            bestSameRankHand = new FullHouse(setOfThreeValues.stream().max((a, b) -> a.compareTo(b)).get(),
                    setOfThreeValues.stream().min((a, b) -> a.compareTo(b)).get());
        } else if (setOfThreeValues.size() == 1 && setOfTwoValues.size() == 1) {

            bestSameRankHand = new FullHouse(setOfThreeValues.stream().findAny().get(),
                    setOfTwoValues.stream().findAny().get());

        } else if (setOfThreeValues.size() == 1 && setOfTwoValues.size() == 0) {

            bestSameRankHand = new ThreeOfAKind(setOfThreeValues.stream().findAny().get());

        } else if (setOfThreeValues.size() == 1 && setOfTwoValues.size() == 2) {
            setOfTwoValues.remove(setOfTwoValues.stream().min((a, b) -> a.compareTo(b)).get());
            bestSameRankHand = new FullHouse(setOfThreeValues.stream().findAny().get(),
                    setOfTwoValues.stream().findAny().get());

        } else if (setOfThreeValues.size() == 0 && setOfTwoValues.size() == 2) {

            bestSameRankHand = generateTwoPairs(cards);

        } else if (setOfThreeValues.size() == 0 && setOfTwoValues.size() == 3) {

            bestSameRankHand = generateTwoPairs(cards);

        } else if (setOfThreeValues.size() == 0 && setOfTwoValues.size() == 1) {

            Rank rank = setOfTwoValues.stream().findAny().get();

            List<Card> cardsList =Arrays.asList(cards)
                    .stream()
                    .distinct()
                    .filter(a ->a.getRank()!=rank)
                    .sorted((a, b) -> RanksValue.rankValues.get(b.getRank()).compareTo(RanksValue.rankValues.get(a.getRank())))
                    .limit(3).collect(Collectors.toList());

            bestSameRankHand = new Pair(rank,cardsList);

        }


        setOfFourValues = new HashSet();
        setOfThreeValues = new HashSet();
        setOfTwoValues = new HashSet();
        return bestSameRankHand;
    }


    public int findNumberOfCardsOfGivenRank(Rank rank, Card[] cards) {
        int countOfSameRankCards = 0;

        for (int x = 0; x < cards.length; x++) {
            if (cards[x].getRank().equals(rank)) {
                countOfSameRankCards++;
            }
        }
        return countOfSameRankCards;
    }

    private void addCardsToSetOfRepetitions(Card[] cards) {
        for (int x = 0; x < cards.length; x++) {
            if (Integer.valueOf(findNumberOfCardsOfGivenRank(cards[x].getRank(), cards)) == 2) {
                setOfTwoValues.add(cards[x].getRank());
            } else if (Integer.valueOf(findNumberOfCardsOfGivenRank(cards[x].getRank(), cards)) == 3) {
                setOfThreeValues.add(cards[x].getRank());
            } else if (Integer.valueOf(findNumberOfCardsOfGivenRank(cards[x].getRank(), cards)) == 4) {
                setOfFourValues.add(cards[x].getRank());
            }
        }
    }

    private TwoPairs generateTwoPairs(Card [] cards){
        Rank rankOfFirstPair = setOfTwoValues.stream().max((a, b) -> a.compareTo(b)).get();
        Rank rankOfSecondPair = setOfTwoValues.stream().min((a, b) -> a.compareTo(b)).get();
        Card card =Arrays.asList(cards)
                .stream()
                .distinct()
                .filter(a ->a.getRank()!=rankOfFirstPair)
                .filter(a ->a.getRank()!=rankOfSecondPair)
                .max((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank())))
                .get();

        System.out.println(card);


        return new TwoPairs(
                rankOfFirstPair,
                rankOfSecondPair,
                card);
    }


}
