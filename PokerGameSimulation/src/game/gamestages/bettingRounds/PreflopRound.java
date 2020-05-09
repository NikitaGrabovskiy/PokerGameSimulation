package game.gamestages.bettingRounds;

import game.card.TwoCardsInPlayersHands;
import game.GameConstants;
import game.GameVariables;
import player.Player;


public class PreflopRound extends Round {

    // FIRST ROUND
    /// Small blind is the first who will act

    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        setEverythingUpForFirstRound();
        for (int x = GameVariables.playerWhoPutSmallBlind; x < GameVariables.allPlayers.size(); x++) {
            GameVariables.allPlayers.get(x).playPreFlopRound();
        }
        for (int x = GameVariables.playerWhoPutSmallBlind-1; x >=0; x--) {
            GameVariables.allPlayers.get(x).playPreFlopRound();
        }
    }

    private void setEverythingUpForFirstRound() {
        placeSmallBlind();
        placeBigBlind();
        giveTwoCardsForEachPlayer();
    }


    private void giveTwoCardsForEachPlayer() {
        for (int x = 0; x < GameVariables.allPlayers.size(); x++) {
            Player player = GameVariables.allPlayers.get(x);
            player.setTwoCardsInPlayersHands(new TwoCardsInPlayersHands(GameVariables.shuffledDeck.getNextCard(),
                    GameVariables.shuffledDeck.getNextCard()));
        }
    }

    private void placeSmallBlind() {
        GameVariables.moneyPot += GameConstants.minimalBet;
        GameVariables.allPlayers.get(GameVariables.playerWhoPutSmallBlind).deductAmountFromPlayersMoney(GameConstants.minimalBet);
    }

    private void placeBigBlind() {
        GameVariables.moneyPot += 2 * GameConstants.minimalBet;
        GameVariables.allPlayers.get(GameVariables.playerWhoPutBigBlind)
                .deductAmountFromPlayersMoney(2 * GameConstants.minimalBet);
    }
}
