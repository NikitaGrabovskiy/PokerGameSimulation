package game;

import game.card.Communitycards;
import game.card.ShuffledDeck;
import game.gameutil.DeckGenerator;
import player.ComputerPlayer;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameVariables {

    public static BigGameSession bigGameSession;

    public static Communitycards communitycards;

    public static int currentPlayerNumber;

    public static int moneyPot;

    public static ShuffledDeck shuffledDeck;

    public static int gameNumber;

    public static int playerWhoPutSmallBlind;

    public static List<Player> allPlayers;

    private static DeckGenerator deckGenerator;


    public static void prepareGameVariablesForBigGameSession() {
        allPlayers = new ArrayList<>(6);
        bigGameSession = new BigGameSession();
        generatePlayers();
        deckGenerator = new DeckGenerator();
        gameNumber = 0;
        playerWhoPutSmallBlind = 1;
    }

    public static void prepareGameVariablesForNewGame() {
        playerWhoPutSmallBlind = 1;
        currentPlayerNumber = 1;
        moneyPot = 0;
        shuffledDeck = deckGenerator.getNewShuffledDeck();
        allPlayers.stream().forEach(a -> a.setStillInTheGame(true));
        allPlayers.stream().forEach(a -> a.setTwoCardsInPlayersHands(null));
        communitycards = null;

    }

    public static void prepareGameVariablesForRound() {
        currentPlayerNumber = 1;
    }

    public static void afterGameIsOver() {
        gameNumber++;

        communitycards = null;

        if ((playerWhoPutSmallBlind + 1) > allPlayers.size()) {
            playerWhoPutSmallBlind = 1;
        } else {
            playerWhoPutSmallBlind++;
        }
    }

    private static void generatePlayers() {
        for (int x = 1; x < GameConstants.amountOfPlayersAtBeginningOfGame + 1; x++) {
            ComputerPlayer computerPlayer = new ComputerPlayer();
            computerPlayer.setMoneyAmount(GameConstants.startingPlayersMoneyAmount);
            computerPlayer.setNumber(x);
            allPlayers.add(computerPlayer);
        }
    }


}