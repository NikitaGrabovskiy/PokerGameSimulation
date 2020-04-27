import game.BigGameSession;
import game.GameVariables;
import game.card.Card;
import game.card.Rank;
import game.card.Suit;
import game.gamestages.resultsEvaluator.bestHandsFinder.TempFindStraight;
import game.gameutil.FindPattern.SequenceFinder;

public class Main {

    public static void main(String[] args) {

        new BigGameSession().startBigGameSession();

       // GameVariables.allPlayers.values().stream().forEach(a -> System.out.println(a.getTwoCardsInPlayersHands()));

       // System.out.println(GameVariables.communitycards);

        Card [] cards = new Card[6];

        cards[0] = new Card(Rank.QUEEN, Suit.CLUBS);
        cards[1] = new Card(Rank.JACK, Suit.CLUBS);
        cards[2] = new Card(Rank.SIX, Suit.CLUBS);
        cards[3] = new Card(Rank.THREE, Suit.CLUBS);
        cards[4] = new Card(Rank.TEN, Suit.CLUBS);
        cards[5] = new Card(Rank.FOUR, Suit.CLUBS);
        cards[5] = new Card(Rank.KING, Suit.CLUBS);

        TempFindStraight tempFindStraight = new TempFindStraight();
       tempFindStraight.findIfThereIsStraight(cards);




    }
}
