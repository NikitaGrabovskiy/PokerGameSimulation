package game.gamestages.bettingRounds;

import game.card.Communitycards;
import game.GameVariables;

public class FlopRound extends Round {

    //SECOND ROUND

    @Override
    public void startRound() {
        GameVariables.prepareGameVariablesForRound();
        setCommunityCards();
        for (int x = GameVariables.playerWhoPutSmallBlind; x < GameVariables.allPlayers.size(); x++) {
            GameVariables.allPlayers.get(x).playFlopRound();
        }
        for (int x = GameVariables.playerWhoPutSmallBlind-1; x >=0; x--) {
            GameVariables.allPlayers.get(x).playFlopRound();
        }
    }

    private void setCommunityCards(){
        GameVariables.communitycards = new Communitycards(GameVariables.shuffledDeck.getNextCard(),
                GameVariables.shuffledDeck.getNextCard(),
                GameVariables.shuffledDeck.getNextCard());
    }









}
