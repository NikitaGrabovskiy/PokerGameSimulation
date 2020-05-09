package game.gamestages.bettingRounds;

import game.GameVariables;

public class TurnRound extends Round {

    // THIRD ROUND

    @Override
    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        addOneCard();
        for (int x = GameVariables.playerWhoPutSmallBlind; x < GameVariables.allPlayers.size(); x++) {
            GameVariables.allPlayers.get(x).playTurnRound();
        }
        for (int x = GameVariables.playerWhoPutSmallBlind-1; x >=0; x--) {
            GameVariables.allPlayers.get(x).playTurnRound();
        }
    }
    private void addOneCard(){
        GameVariables.communitycards.setCardFour(GameVariables.shuffledDeck.getNextCard());
    }
}
