package display;

import game.Game;
import game.GameVariables;
import game.card.Card;
import game.card.Rank;
import game.card.Suit;
import game.card.hands.*;
import game.gameutil.staticdata.CardSymbols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DisplaySingleAutomaticGame implements ActionListener {

    private static final int widthOfACard = 85;
    private static final int heightOfACard = 95;
    private JPanel jPanel;
    private List<JButton> playerTagsButtons;


    public DisplaySingleAutomaticGame(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.jPanel.removeAll();
        addNextGameButton(this.jPanel);
        new Game().playGame();
        displayCommunityCards();
        addPlayersCards();
        displayWinningHand();
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
        button1.setBounds(580, 570, 200, 50);
        button1.setFont(button1.getFont().deriveFont(1, 30));
        button1.setForeground(Color.RED);
        button1.setContentAreaFilled(true);
        button1.addActionListener(this);
        jPanel.add(button1);
    }

    private void addPlayersCards() {
        int startingX = 10;
        int startingY = 100;

        playerTagsButtons = new ArrayList<>();

        for (int a = 0; a < GameVariables.allPlayers.size(); a++) {

            JButton button1 = new JButton("Player " + GameVariables.allPlayers.get(a).getNumber());
            button1.setBorderPainted(false);
            button1.setBounds(startingX, startingY, 200, 100);
            if(GameVariables.winnerHandMap.containsKey(GameVariables.allPlayers.get(a))){
                button1.setForeground(new Color(50,200,50));
                button1.setText("WINNER");
                button1.setFont(button1.getFont().deriveFont(1, 20));
            }else{
            button1.setForeground(Color.darkGray);
                button1.setFont(button1.getFont().deriveFont(1, 15));
            }
            button1.setContentAreaFilled(false);
            playerTagsButtons.add(button1);
            this.jPanel.add(button1);
            createCard(GameVariables.allPlayers.get(a).getTwoCardsInPlayersHands().getCards().get(0), startingX, startingY + 70);
            createCard(GameVariables.allPlayers.get(a).getTwoCardsInPlayersHands().getCards().get(1), startingX + 100, startingY + 70);

            startingX += 300;

            if (a == 2) {
                startingY += 150;
                startingX = 10;
            }
        }
    }

    private void displayCommunityCards(){
        createCard(GameVariables.communitycards.getCardOne(),150, 20);
        createCard(GameVariables.communitycards.getCardTwo(), 250, 20);
        createCard(GameVariables.communitycards.getCardThree(), 350, 20);
        createCard(GameVariables.communitycards.getCardFour(), 450, 20);
        createCard(GameVariables.communitycards.getCardFive(), 550, 20);
    }

    private void displayWinningHand(){

        int xLocationStart = 150;
        int yLocation= 465;
        Hand hand = GameVariables.winnerHandMap.values().stream().findAny().get();
        JButton winningHandLabel = new JButton(hand.toString());
        winningHandLabel.setBorderPainted(false);
        winningHandLabel.setBounds(150, 388, 500, 100);
        winningHandLabel.setFont(winningHandLabel.getFont().deriveFont(2, 20));
        winningHandLabel.setForeground(new Color(255,255,00));
        winningHandLabel.setContentAreaFilled(false);
        this.jPanel.add(winningHandLabel);

        if(hand instanceof StraightFlush){
            displayFiveCards(xLocationStart,yLocation,((StraightFlush)hand).getCardsOfStraightFlush());
        } else if (hand instanceof FourOfAKind){
            Rank rank = ((FourOfAKind)hand).getRank();
            createCard(new Card(rank,Suit.CLUBS), xLocationStart, yLocation);
            createCard(new Card(rank,Suit.DIAMONDS), xLocationStart+100, yLocation);
            createCard(new Card(rank,Suit.HEARTS), xLocationStart+200, yLocation);
            createCard(new Card(rank,Suit.SPADES), xLocationStart+300, yLocation);
        } else if(hand instanceof FullHouse){
            createSeveralCardsWithoutSuit(3,((FullHouse)hand).getRankOfTreeCards(),xLocationStart,yLocation);
            createSeveralCardsWithoutSuit(2,((FullHouse)hand).getRankOfTwoCards(),xLocationStart+300,yLocation);
        } else if(hand instanceof Flush){
            displayFiveCards(xLocationStart,yLocation,((Flush)hand).getCardsOfFlush());
        }else if(hand instanceof Straight){
            displayFiveCards(xLocationStart,yLocation,((Straight)hand).getCardsOfStraightHand());
        }else if(hand instanceof ThreeOfAKind){
            createSeveralCardsWithoutSuit(3,((ThreeOfAKind)hand).getRank(),xLocationStart,yLocation);
        }else if(hand instanceof TwoPairs){
            createSeveralCardsWithoutSuit(2,((TwoPairs)hand).getRankOfFirstPair(),xLocationStart,yLocation);
            createSeveralCardsWithoutSuit(2,((TwoPairs)hand).getRankOfSecondPair(),xLocationStart+200,yLocation);
        }else if(hand instanceof Pair){
            createSeveralCardsWithoutSuit(2,((Pair)hand).getRank(),xLocationStart,yLocation);
        }else if(hand instanceof HighCard){
            Card [] cards = new Card[5];
            displayFiveCards(xLocationStart,yLocation,((HighCard)hand).getFiveCards().toArray(cards));
        }
    }

    private void displayFiveCards(int xLocationStart,int yLocation,Card [] cards){
        createCard(cards[0], xLocationStart, yLocation);
        createCard(cards[1], xLocationStart+100, yLocation);
        createCard(cards[2], xLocationStart+200, yLocation);
        createCard(cards[3], xLocationStart+300, yLocation);
        createCard(cards[4], xLocationStart+400, yLocation);
    }

    private void createSeveralCardsWithoutSuit(int numberOfCards, Rank rank, int xLocation, int yLocation) {
        String cardValue = CardSymbols.rankSymbols.get(rank);
        for(int a = 0; a< numberOfCards;a++) {
            JButton button = new JButton(cardValue);
            button.setBorderPainted(true);
            button.setContentAreaFilled(true);
            button.setBounds(xLocation, yLocation, widthOfACard, heightOfACard);
            button.setFont(button.getFont().deriveFont(1, 30));
            button.setForeground(new Color(200, 200, 100));
            jPanel.add(button);
            jPanel.repaint();
            xLocation+=100;
        }
    }


}
