package game;

import game.gamestages.bettingRounds.FlopRound;
import game.gamestages.bettingRounds.PreflopRound;
import game.gamestages.bettingRounds.RiverRound;
import game.gamestages.bettingRounds.TurnRound;
import game.gamestages.resultsEvaluator.ResultsEvaluator;

public class Game {

    public void playGame() {

        GameVariables.prepareGameVariablesForNewGame();

        new PreflopRound().startRound();
        new FlopRound().startRound();
        new TurnRound().startRound();
        new RiverRound().startRound();
        new ResultsEvaluator().evaluateResults();

    }


}
