package game.gamestages.resultsEvaluator.bestHandsFinder;

import game.GameVariables;
import game.card.Card;
import game.card.hands.Flush;
import game.card.hands.Hand;
import player.Player;

public class BestHandsFinder {

    public Hand findBestHand(Player player){

        Card [] allCards = new Card[7];

        allCards [0] = player.getTwoCardsInPlayersHands().getCardOne();
        allCards [1] = player.getTwoCardsInPlayersHands().getCardTwo();
        allCards [2] = GameVariables.communitycards.getCardOne();
        allCards [3] = GameVariables.communitycards.getCardTwo();
        allCards [4] = GameVariables.communitycards.getCardThree();
        allCards [5] = GameVariables.communitycards.getCardFour();
        allCards [6] = GameVariables.communitycards.getCardFive();

        Hand hand = null;

        Flush flush = HandFinder.findFlush(allCards);

        return hand;
    }



}
