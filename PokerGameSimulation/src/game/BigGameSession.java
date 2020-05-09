package game;

public class BigGameSession {

    public void startBigGameSession(){
        GameVariables.prepareGameVariablesForBigGameSession();
    }

    public void playNewGame(){
        while (GameVariables.allPlayers.size()>1) {
            new Game().playGame();
            GameVariables.afterGameIsOver();

            GameVariables.allPlayers.stream()
                    .forEach(a -> System.out.println(a.getNumber()+ "  "+ a.getMoneyAmount()));
            System.out.println("*******************");

        }

        System.out.println("*******************");
        System.out.println("*******************");
        System.out.println("*******************");
        GameVariables.allPlayers.stream()
                .forEach(a -> System.out.println(a.getNumber()+ "  "+ a.getMoneyAmount()));

    }

}
