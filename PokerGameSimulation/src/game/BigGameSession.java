package game;

public class BigGameSession {

    public void startBigGameSession(){
        GameVariables.prepareGameVariablesForBigGameSession();

        //while (GameVariables.allPlayers.size()>1){
            new Game().playGame();
        //}
    }

}
