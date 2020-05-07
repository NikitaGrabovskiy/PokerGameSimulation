package display;

import game.GameVariables;
import game.card.Card;
import game.card.Suit;
import game.gameutil.staticdata.CardSymbols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenForButton implements ActionListener {

    private static final int widthOfACard = 85;
    private static final int heightOfACard = 95;
    private int yLocationOfPlayersTwoCards = 60;
    JPanel jPanel;

    public ListenForButton(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.jPanel.removeAll();
        addNextGameButton(this.jPanel);
        System.out.println("LLLL");

        GameVariables.bigGameSession.playNewGame();
        createCard(GameVariables.communitycards.getCardOne(), 150, 20);
        createCard(GameVariables.communitycards.getCardTwo(), 250, 20);
        createCard(GameVariables.communitycards.getCardThree(), 350, 20);
        createCard(GameVariables.communitycards.getCardFour(), 450, 20);
        createCard(GameVariables.communitycards.getCardFive(), 550, 20);
        addPlayersCards();
        //  GameVariables.allPlayers.values().forEach(a -> addPlayersTwoCards(a,yLocationOfPlayersTwoCards+=100));
        yLocationOfPlayersTwoCards=60;
        GameVariables.afterGameIsOver();

    }

    private void createCard(Card card, int xLocation, int yLocation) {
        String cardValue = CardSymbols.rankSymbols.get(card.getRank())
                + CardSymbols.suitSymbols.get(card.getSuit());
        JButton button = new JButton(cardValue);
        button.setBorderPainted(true);
        button.setContentAreaFilled(true);
        button.setBounds(xLocation, yLocation, widthOfACard, heightOfACard);
        button.setFont(button.getFont().deriveFont(1, 30));
        if (card.getSuit().equals(Suit.DIAMONDS) || card.getSuit().equals(Suit.HEARTS)) {
            button.setForeground(Color.RED);
        } else {
            button.setForeground(Color.BLACK);
        }
        jPanel.add(button);
        jPanel.repaint();
    }

    private void addNextGameButton(JPanel jPanel) {
        JButton button1 = new JButton("Next game");
        button1.setBorderPainted(true);
        button1.setBounds(300, 550, 200, 50);
        button1.setFont(button1.getFont().deriveFont(1, 30));
        button1.setForeground(Color.RED);
        button1.setContentAreaFilled(true);
        button1.addActionListener(this);
        jPanel.add(button1);
    }

    private void addPlayersCards(){
    int startingX = 10;
    int startingY = 100;

    for(int a =0; a< GameVariables.allPlayers.size();a++){

        JButton button1 = new JButton("Player " + GameVariables.allPlayers.get(a).getNumber());
        button1.setBorderPainted(false);
        button1.setBounds(startingX,startingY,200,100);
        button1.setFont(button1.getFont().deriveFont(1, 15));
        button1.setForeground(Color.MAGENTA);
        button1.setContentAreaFilled(false);
        this.jPanel.add(button1);
        createCard(GameVariables.allPlayers.get(a).getTwoCardsInPlayersHands().getCards().get(0),startingX,startingY+70);
        createCard(GameVariables.allPlayers.get(a).getTwoCardsInPlayersHands().getCards().get(1),startingX+100,startingY+70);

        startingX+=300;

        if(a==2){
            startingY+=150;
            startingX=10;
        }

    }




    }

/*        private void addPlayer(Player player,int playersNumber,int yLocation){
            JButton button1 = new JButton("Player " + playersNumber);
            button1.setBorderPainted(false);
            button1.setBounds(new Point(20,20), 200, 50);
            button1.setFont(button1.getFont().deriveFont(1, 30));
            button1.setForeground(Color.MAGENTA);
            button1.setContentAreaFilled(false);
            this.jPanel.add(button1);
            createCard(player.getTwoCardsInPlayersHands().getCards().get(0),150,yLocation);
            createCard(player.getTwoCardsInPlayersHands().getCards().get(1),250,yLocation);
        }*/
}
