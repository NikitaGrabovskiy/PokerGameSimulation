package game.gamestages.resultsEvaluator;

import game.GameVariables;
import game.card.Card;
import game.card.Rank;
import game.card.hands.*;
import game.gamestages.resultsEvaluator.bestHandsFinder.BestHandsFinder;
import game.gameutil.staticdata.RanksValue;
import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResultsEvaluator {

    public void evaluateResults() {

        System.out.println(GameVariables.communitycards);
        System.out.println("************************************");
        GameVariables.allPlayers.forEach(a -> System.out.println(a.getTwoCardsInPlayersHands()));
        System.out.println("************************************");
        System.out.println("WINNERS ARE :");
        Arrays.asList(findWinners()).stream().forEach(a -> System.out.println(a.getTwoCardsInPlayersHands()));
    }

    public Player[] findWinners() {
        BestHandsFinder bestHandsFinder = new BestHandsFinder();
        Map<Hand, Player> mapOfPlayerHands = new ConcurrentHashMap<>();

        GameVariables.allPlayers
                .stream()
                .filter(a -> a.isStillInTheGame())
                .forEach(a -> mapOfPlayerHands.put(bestHandsFinder.findBestHand(a), a));

        Hand winningHand = mapOfPlayerHands
                .keySet()
                .stream()
                .max((a, b) -> new Integer(a.getValue()).compareTo(new Integer(b.getValue()))).get();

        mapOfPlayerHands
                .keySet()
                .stream()
                .filter(a -> a.getValue() != winningHand.getValue())
                .forEach(a -> mapOfPlayerHands.remove(a));

        Player[] players;

        if (mapOfPlayerHands.size() == 1) {
            players = new Player[1];
            players[0] = mapOfPlayerHands.values().stream().findAny().get();
        } else {
           players = findWinnersWithSameValueHands(mapOfPlayerHands);
        }

        System.out.println("Winning hand is " + mapOfPlayerHands.keySet().stream().findAny().get());

        return players;
    }

    private Player[] findWinnersWithSameValueHands(Map<Hand, Player> mapOfPlayerHands) {

        List<Player> winningPlayers = new ArrayList<>();
        Hand hand = mapOfPlayerHands.keySet()
                .stream()
                .max((a, b) -> a.compareTo(b))
                .get();

        mapOfPlayerHands.keySet()
                .stream()
                .filter(a -> (a.compareTo(hand) == 0))
                .forEach(a -> winningPlayers.add(mapOfPlayerHands.get(a)));


 /*       if (hand instanceof StraightFlush) {

        } else if (hand instanceof FourOfAKind) {


        } else if (hand instanceof FullHouse) {

            FullHouse fullHouse = mapOfPlayerHands.keySet()
                    .stream()
                    .map(a -> (FullHouse) a)
                    .max((a, b) -> a.compareTo(b))
                    .get();

            winningPlayers.add(mapOfPlayerHands.get(fullHouse));

        } else if (hand instanceof Flush) {

        } else if (hand instanceof Straight) {

        } else if (hand instanceof ThreeOfAKind) {

            ThreeOfAKind threeOfAKind = mapOfPlayerHands.keySet()
                    .stream()
                    .map(a -> (ThreeOfAKind) a)
                    .max((a, b) -> a.compareTo(b))
                    .get();
            winningPlayers.add(mapOfPlayerHands.get(threeOfAKind));

        } else if (hand instanceof TwoPairs) {

        } else if (hand instanceof Pair) {

        } else if (hand instanceof HighCard) {

        }*/


        Player[] winningPlayersArray = new Player[winningPlayers.size()];
        winningPlayers.toArray(winningPlayersArray);
        return winningPlayersArray;
    }



    public int compareTwoCardLists(List<Card> listOne, List<Card> listTwo) {
        for (int x = 0; x < 5; x++) {
            Rank maxRankOfFirstHighCardHand = findLargestRankInHighCardHand(listOne);
            Rank maxRankOfSecondHighCardHand = findLargestRankInHighCardHand(listTwo);
            if (RanksValue.rankValues.get(maxRankOfFirstHighCardHand) > RanksValue.rankValues.get(maxRankOfSecondHighCardHand)) {
                return 1;
            } else if (RanksValue.rankValues.get(maxRankOfFirstHighCardHand) < RanksValue.rankValues.get(maxRankOfSecondHighCardHand)) {
                return -1;
            } else {
                listOne.removeIf(a -> a.getRank().equals(maxRankOfFirstHighCardHand));
                listTwo.removeIf(a -> a.getRank().equals(maxRankOfSecondHighCardHand));
            }
        }
        return 0;
    }

    private Rank findLargestRankInHighCardHand(List<Card> cardList) {
        return cardList
                .stream()
                .max((a, b) -> RanksValue.rankValues.get(b.getRank()).compareTo(RanksValue.rankValues.get(a.getRank())))
                .get()
                .getRank();
    }
}
