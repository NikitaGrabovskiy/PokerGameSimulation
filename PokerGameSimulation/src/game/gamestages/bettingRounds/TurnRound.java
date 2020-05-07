package game.gamestages.bettingRounds;

import game.GameVariables;

public class TurnRound extends Round {

    // THIRD ROUND


    @Override
    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        addOneCard();
        for(int x = 0; x< GameVariables.allPlayers.size();x++){
            GameVariables.allPlayers.get(x).playTurnRound();
        }


    }

    private void addOneCard(){
        GameVariables.communitycards.setCardFour(GameVariables.shuffledDeck.getNextCard());
    }


}
