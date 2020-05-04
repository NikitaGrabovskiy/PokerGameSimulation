package game;

import game.card.Communitycards;
import game.card.ShuffledDeck;
import game.gameutil.DeckGenerator;
import player.ComputerPlayer;
import player.Player;

import java.util.HashMap;
import java.util.Map;

public class GameVariables {

    public static Communitycards communitycards;

    public static int currentPlayerNumber;

    public static int moneyPot;

    public static ShuffledDeck shuffledDeck;

    public static int gameNumber;

    public static int playerWhoPutSmallBlind;

    public static Map<Integer, Player> allPlayers;

    private static DeckGenerator deckGenerator;





    public static void prepareGameVariablesForBigGameSession() {
        generatePlayers();
        deckGenerator = new DeckGenerator();
        gameNumber = 0;
        playerWhoPutSmallBlind =1;
    }

    public static void prepareGameVariablesForNewGame() {
        playerWhoPutSmallBlind =1;
        currentPlayerNumber = 1;
        moneyPot = 0;
        shuffledDeck = deckGenerator.getNewShuffledDeck();
        allPlayers.values().stream().forEach(a ->a.setStillInTheGame(true));
    }

    public static void prepareGameVariablesForRound() {
        moneyPot = 0;
        currentPlayerNumber =1;
    }

    public static void afterGameIsOver(){
        gameNumber++;

        communitycards = null;

        if((playerWhoPutSmallBlind+1)>allPlayers.size()){
            playerWhoPutSmallBlind=1;
        }else {
            playerWhoPutSmallBlind++;
        }
    }

    private static void generatePlayers(){
        allPlayers = new HashMap<>();
        for(int x = 1; x<GameConstants.amountOfPlayersAtBeginningOfGame+1;x++){
            ComputerPlayer computerPlayer = new ComputerPlayer();
            computerPlayer.setMoneyAmount(GameConstants.startingPlayersMoneyAmount);
            allPlayers.put(x,computerPlayer);
        }
    }


}