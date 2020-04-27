package game.gamestages.bettingRounds;

public abstract class Round {

    protected abstract void startRound();

/*    protected Player getNextPlayer() {
        if ((GameVariables.currentPlayerNumber + 1) > GameVariables.allPlayers.size()) {
            return null;
        } else {
            GameVariables.currentPlayerNumber++;
        }
        return GameVariables.allPlayers.get(GameVariables.currentPlayerNumber);
    }*/


}
