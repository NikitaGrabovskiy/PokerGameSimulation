package game.gamestages.bettingRounds;

import game.card.Communitycards;
import game.GameVariables;

public class FlopRound extends Round {

    //SECOND ROUND
    /// Small blind is the first who will act


    @Override
    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        setCommunityCards();
        for(int x = 1; x< GameVariables.allPlayers.size()+1;x++){
            GameVariables.allPlayers.get(x).playFlopRound();
        }
    }

    private void setCommunityCards(){
        GameVariables.communitycards = new Communitycards(GameVariables.shuffledDeck.getNextCard(),
                GameVariables.shuffledDeck.getNextCard(),
                GameVariables.shuffledDeck.getNextCard());
    }









}
