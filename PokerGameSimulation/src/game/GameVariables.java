package game;

import game.card.Communitycards;
import game.card.ShuffledDeck;
import game.card.hands.Hand;
import game.gameutil.DeckGenerator;
import player.ComputerPlayer;
import player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameVariables {

    public static BigGameSession bigGameSession;
    public static Communitycards communitycards;
    public static int moneyPot;
    public static ShuffledDeck shuffledDeck;
    public static int gameNumber;
    public static int playerWhoPutSmallBlind;
    public static int playerWhoPutBigBlind;
    public static List<Player> allPlayers;
    public static Map<Player, Hand> winnerHandMap;

    private static DeckGenerator deckGenerator;


    public static void prepareGameVariablesForBigGameSession() {
        winnerHandMap = new HashMap<>();
        allPlayers = new ArrayList<>(6);
        generatePlayers();
        bigGameSession = new BigGameSession();
        deckGenerator = new DeckGenerator();
        gameNumber = 0;
        playerWhoPutSmallBlind = 0;
        playerWhoPutBigBlind = 1;
    }

    public static void prepareGameVariablesForNewGame() {
        winnerHandMap = new HashMap<>();
        moneyPot = 0;

        shuffledDeck = deckGenerator.getNewShuffledDeck();
        allPlayers.stream().forEach(a -> a.setStillInTheGame(true));
        allPlayers.stream().forEach(a -> a.setTwoCardsInPlayersHands(null));
        communitycards = null;

    }

    public static void prepareGameVariablesForRound(){
    }

    public static void afterGameIsOver() {

        if(allPlayers.stream().filter(a -> a.getMoneyAmount()<0).findAny().isPresent()) {

            List<Player> temp = allPlayers.stream()
                    .filter(a -> a.getMoneyAmount() > 0)
                    .collect(Collectors.toList());

            List<Player> changedAllPlayersList = new ArrayList<>();

            for (int x = 0; x < temp.size(); x++) {
                temp.get(x).setNumber(x);
                changedAllPlayersList.add(temp.get(x));
            }

            allPlayers = changedAllPlayersList;

        }

        gameNumber++;
        communitycards = null;
        playerWhoPutSmallBlind += 1;
        playerWhoPutBigBlind += 1;

        if (playerWhoPutSmallBlind > allPlayers.size()) {
            playerWhoPutSmallBlind = 0;
        }

        if (playerWhoPutBigBlind > allPlayers.size()) {
            playerWhoPutBigBlind = 0;
        }
    }

    private static void generatePlayers() {
        for (int x = 0; x < GameConstants.amountOfPlayersAtBeginningOfGame; x++) {
            ComputerPlayer computerPlayer = new ComputerPlayer();
            computerPlayer.setMoneyAmount(GameConstants.startingPlayersMoneyAmount);
            computerPlayer.setNumber(x);
            allPlayers.add(computerPlayer);
        }
    }


}