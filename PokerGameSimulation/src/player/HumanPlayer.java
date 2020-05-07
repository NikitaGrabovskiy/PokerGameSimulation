package player;

import game.card.TwoCardsInPlayersHands;

public class HumanPlayer implements Player {

    private TwoCardsInPlayersHands twoCardsInPlayersHands;

    private int moneyAmount;

    private boolean stillInTheGame;

    private String name;

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public TwoCardsInPlayersHands getTwoCardsInPlayersHands() {
        return twoCardsInPlayersHands;
    }

    public boolean isStillInTheGame() {
        return stillInTheGame;
    }

    public void setStillInTheGame(boolean stillInTheGame) {
        this.stillInTheGame = stillInTheGame;
    }

    public void setTwoCardsInPlayersHands(TwoCardsInPlayersHands twoCardsInPlayersHands) {
        this.twoCardsInPlayersHands = twoCardsInPlayersHands;
    }

    @Override
    public void deductAmountFromPlayersMoney(int deductionAmount) {
        moneyAmount -= deductionAmount;
    }


    @Override
    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void playPreFlopRound() {

    }

    @Override
    public void playFlopRound() {

    }

    @Override
    public void playTurnRound() {

    }

    @Override
    public void playRiverRound() {

    }

    @Override
    public void fold() {

    }

    @Override
    public void raise() {

    }

    @Override
    public void call() {

    }
}
