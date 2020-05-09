package game.gamestages.resultsEvaluator;

import game.GameVariables;
import game.card.Card;
import game.card.Rank;
import game.card.hands.*;
import game.gamestages.resultsEvaluator.bestHandsFinder.BestHandsFinder;
import game.gameutil.staticdata.RanksValue;
import player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResultsEvaluator {

    public void evaluateResults() {
       GameVariables.winnerHandMap = generateWinnerHandMap();

       if(GameVariables.winnerHandMap.size()==1){
           GameVariables.winnerHandMap.keySet().stream()
                   .findAny()
                   .get()
                   .addToMoneyAmount(GameVariables.moneyPot);
       } else{
           int winningShare = GameVariables.moneyPot/generateWinnerHandMap().size();
           GameVariables.winnerHandMap.keySet()
                   .stream()
                   .forEach(a->a.addToMoneyAmount(winningShare));
       }








    }

    public Map<Player,Hand> generateWinnerHandMap() {
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


        Map<Player,Hand> winnerHandMap;

        if (mapOfPlayerHands.size() == 1) {

            winnerHandMap = new HashMap<>();
            winnerHandMap.put(mapOfPlayerHands.values().stream().findAny().get(),winningHand);
        } else {
           winnerHandMap = findWinnersWithSameValueHands(mapOfPlayerHands);
        }

        return winnerHandMap;
    }

    private Map<Player,Hand> findWinnersWithSameValueHands(Map<Hand, Player> mapOfPlayerHands) {

        Map<Player,Hand> winnerHandMap = new HashMap<>();

        List<Player> winningPlayers = new ArrayList<>();
        Hand hand = mapOfPlayerHands.keySet()
                .stream()
                .max((a, b) -> a.compareTo(b))
                .get();

        mapOfPlayerHands.keySet()
                .stream()
                .filter(a -> (a.compareTo(hand) == 0))
                .forEach(a -> winnerHandMap.put(mapOfPlayerHands.get(a),a));
        return winnerHandMap;
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
