import game.BigGameSession;
import game.GameVariables;
import game.card.*;
import game.card.hands.HighCard;
import game.gamestages.resultsEvaluator.ResultsEvaluator;
import game.gamestages.resultsEvaluator.bestHandsFinder.BestHandsFinder;
import player.ComputerPlayer;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main extends JFrame {

    public static void main(String[] args) {

        new Main();

/*        Card card1 = new Card(Rank.EIGHT, Suit.HEARTS);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);
        Card card3 = new Card(Rank.JACK, Suit.HEARTS);
        Card card4 = new Card(Rank.KING, Suit.HEARTS);
        Card card5 = new Card(Rank.TEN, Suit.HEARTS);
        Card card6 = new Card(Rank.TWO, Suit.HEARTS);
        Card card7 = new Card(Rank.QUEEN, Suit.HEARTS);*/

/*
        Card card3 = new Card(Rank.THREE, Suit.HEARTS);
        Card card4 = new Card(Rank.TWO, Suit.CLUBS);
        Card card5 = new Card(Rank.KING, Suit.SPADES);
        Card card6 = new Card(Rank.THREE, Suit.CLUBS);
        Card card7 = new Card(Rank.QUEEN, Suit.HEARTS);

        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.CLUBS);

        Card card8 = new Card(Rank.TWO, Suit.HEARTS);
        Card card9 = new Card(Rank.KING, Suit.HEARTS);
*/

/*        Communitycards communitycards = new Communitycards(card3,card4,card5);
        communitycards.setCardFour(card6);
        communitycards.setCardFive(card7);

        Player player = new ComputerPlayer();
        player.setTwoCardsInPlayersHands(new TwoCardsInPlayersHands(card1,card2));
        GameVariables.communitycards = communitycards;*/

      //  BestHandsFinder bestHandsFinder = new BestHandsFinder();
       // System.out.println(bestHandsFinder.findBestHand(player));

/*        List<Card > cardsList = new ArrayList<>();
        cardsList.add(new Card(Rank.TWO, Suit.HEARTS));
        cardsList.add(new Card(Rank.THREE, Suit.CLUBS));
        cardsList.add(new Card(Rank.KING, Suit.CLUBS));
        cardsList.add(new Card(Rank.JACK, Suit.HEARTS));
        cardsList.add(new Card(Rank.ACE,Suit.HEARTS));

        List<Card > cardsListTwo = new ArrayList<>();
        cardsListTwo.add(new Card(Rank.TWO, Suit.HEARTS));
        cardsListTwo.add(new Card(Rank.THREE, Suit.CLUBS));
        cardsListTwo.add(new Card(Rank.KING, Suit.CLUBS));
        cardsListTwo.add(new Card(Rank.JACK, Suit.HEARTS));
        cardsListTwo.add(new Card(Rank.ACE,Suit.HEARTS));



        int a = resultsEvaluator.compareHighCardsHands(new HighCard(cardsList),
               new HighCard(cardsListTwo));*/

       // System.out.println(a);


        new BigGameSession().startBigGameSession();


    }


    public Main(){
        this.setSize(800, 800);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("POKER GAME");

        JPanel thePanel = new JPanel();
        thePanel.setLayout(null);

/*
        JLabel label3 = new JLabel("");
        thePanel.add(label3);*/

        ListenForButton listenForButton = new ListenForButton();

        JButton button1 = new JButton("2D");
        button1.setBorderPainted(true);
        button1.setBounds(300,20,200,50);
        button1.setFont(button1.getFont().deriveFont(1,30));
        button1.setForeground(Color.RED);
        button1.setContentAreaFilled(true);
        button1.addActionListener(listenForButton);
        thePanel.add(button1);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                new BigGameSession().startBigGameSession();
            }catch (Exception exception){
                System.out.println(exception);
            }


        }
    }
}
