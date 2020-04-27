package game.gamestages.bettingRounds;

import game.GameVariables;

public class RiverRound extends Round  {

    /// FOURTH ROUND

    @Override
    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        addOneCard();
        for(int x = 1; x< GameVariables.allPlayers.size()+1;x++){
            GameVariables.allPlayers.get(x).playRiverRound();
        }
    }

    private void addOneCard(){
        GameVariables.communitycards.setCardFive(GameVariables.shuffledDeck.getNextCard());
    }

}
