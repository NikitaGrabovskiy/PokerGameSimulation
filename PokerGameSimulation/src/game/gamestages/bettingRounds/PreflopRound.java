package game.gamestages.bettingRounds;

import game.card.TwoCardsInPlayersHands;
import game.GameConstants;
import game.GameVariables;
import player.Player;

import java.util.Map;

public class PreflopRound extends Round  {

        // FIRST ROUND

    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        setEverythingUpForFirstRound();

    }


    private void setEverythingUpForFirstRound() {
        placeSmallBlind();
        placeBigBlind();
        giveTwoCardsForEachPlayer(GameVariables.allPlayers);
    }


    private void giveTwoCardsForEachPlayer(Map<Integer, Player> players) {

        for(int x = 1; x < GameVariables.allPlayers.size()+1;x++){

            Player player = GameVariables.allPlayers.get(x);
            player.setTwoCardsInPlayersHands(new TwoCardsInPlayersHands(GameVariables.shuffledDeck.getNextCard(),
                    GameVariables.shuffledDeck.getNextCard()));
            GameVariables.allPlayers.put(x,player);
        }

    }

    private void placeSmallBlind(){
        GameVariables.moneyPot+= GameConstants.minimalBet;
        GameVariables.allPlayers.get(GameVariables.playerWhoPutSmallBlind).deductAmountFromPlayersMoney(GameConstants.minimalBet);
    }

    private void placeBigBlind(){
        GameVariables.moneyPot+= 2*GameConstants.minimalBet;
        int bigBlindPlayerNumber;
        if((GameVariables.playerWhoPutSmallBlind+1)>GameVariables.allPlayers.size()){
            bigBlindPlayerNumber = 1;
        }else {
            bigBlindPlayerNumber=++GameVariables.playerWhoPutSmallBlind;
        }
        GameVariables.allPlayers.get(bigBlindPlayerNumber).deductAmountFromPlayersMoney(2*GameConstants.minimalBet);
    }
}
