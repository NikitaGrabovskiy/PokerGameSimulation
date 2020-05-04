package game.gamestages.resultsEvaluator.bestHandsFinder;

import game.GameVariables;
import game.card.Card;
import game.card.Suit;
import game.card.hands.*;
import game.gameutil.FindPattern.LargestCardFinder;
import game.gameutil.FindPattern.SequenceFinder;
import game.gameutil.FindPattern.SameRankFinder;
import game.gameutil.FindPattern.SameSuitFinder;
import player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BestHandsFinder {

    private SequenceFinder sequenceFinder = new SequenceFinder();
    private SameRankFinder sameRankFinder = new SameRankFinder();
    private SameSuitFinder sameSuitFinder = new SameSuitFinder();
    private LargestCardFinder largestCardFinder = new LargestCardFinder();

    public Hand findBestHand(Player player) {


        Card[] cards = new Card[7];
        cards[0] = player.getTwoCardsInPlayersHands().getCards().get(0);
        cards[1] = player.getTwoCardsInPlayersHands().getCards().get(1);
        cards[2] = GameVariables.communitycards.getCardOne();
        cards[3] = GameVariables.communitycards.getCardTwo();
        cards[4] = GameVariables.communitycards.getCardThree();
        cards[5] = GameVariables.communitycards.getCardFour();
        cards[6] = GameVariables.communitycards.getCardFive();

        List<Card> cardList = Arrays.asList(cards);
        cardList.removeIf(a -> a == null);

        Card[] temp = new Card[cardList.size()];
        Card[] cardsWithoutNullValues = cardList.toArray(temp);


        Flush flush = sameSuitFinder.findFlush(cardsWithoutNullValues);
        Hand sameRankHand = sameRankFinder.findBestSameRankCombination(cardsWithoutNullValues);
        Straight straight = sequenceFinder.findIfThereIsStraight(cardsWithoutNullValues);
        StraightFlush straightFlush = null;
        HighCard highCard = largestCardFinder.findHighCardHand(cards);

        if (flush != null && straight != null) {
            Suit suitOfFlush = flush.getCardsOfFlush()[0].getSuit();
            List<Card> cards1 = Arrays.asList(cardsWithoutNullValues);
            cards1=cards1.stream().filter(a->a.getSuit().equals(suitOfFlush)).collect(Collectors.toList());
            Card [] tempArray = new Card[cards1.size()];

            Straight straightFlushTemp = sequenceFinder.findIfThereIsStraight(cards1.toArray(tempArray));
            if(straightFlushTemp != null){
            straightFlush = new StraightFlush(straightFlushTemp.getCardsOfStraightHand());}
        }

        return findBestHand(flush, sameRankHand, straight, highCard,straightFlush,player);
    }

    private Hand findBestHand(Flush flush, Hand sameRankHand, Straight straight, HighCard highCard,StraightFlush straightFlush,Player player) {

        Hand hand = null;

        if (straightFlush != null) {
            hand = straightFlush;
        } else if (sameRankHand instanceof FourOfAKind) {
            hand =(FourOfAKind) sameRankHand;
        } else if (sameRankHand instanceof FullHouse) {
            hand = (FullHouse) sameRankHand;
        } else if (flush != null) {
            hand = flush;
        } else if (straight != null) {
            hand = straight;
        } else if (sameRankHand instanceof ThreeOfAKind) {
            hand = (ThreeOfAKind) sameRankHand;
        } else if (sameRankHand instanceof TwoPairs) {
            hand = (TwoPairs) sameRankHand;
        } else if (sameRankHand instanceof Pair) {
            hand =(Pair) sameRankHand;
        } else {
            hand = highCard;
        }
        return hand;
    }
}
