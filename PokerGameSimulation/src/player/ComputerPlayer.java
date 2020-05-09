package player;

import game.GameVariables;
import game.card.TwoCardsInPlayersHands;
import game.strategies.PreFlopRoundStrategy;

public class ComputerPlayer implements Player {

    private boolean stillInTheGame;

    private TwoCardsInPlayersHands twoCardsInPlayersHands;

    private int number;

    private String name;

    public void setNumber(int number) {
        this.number = number;
    }

    public TwoCardsInPlayersHands getTwoCardsInPlayersHands() {
        return twoCardsInPlayersHands;
    }

    public void setTwoCardsInPlayersHands(TwoCardsInPlayersHands twoCardsInPlayersHands) {
        this.twoCardsInPlayersHands = twoCardsInPlayersHands;
    }

    public int getNumber() {
        return number;
    }
    private int moneyAmount;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void deductAmountFromPlayersMoney(int deductionAmount) {
        moneyAmount -= deductionAmount;
    }

    @Override
    public void addToMoneyAmount(int winnings) {
        moneyAmount +=winnings;
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
        PreFlopRoundStrategy.preFlopRoundDecision(this);
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
    public void raise(int bet) {
        GameVariables.moneyPot+=bet;
        deductAmountFromPlayersMoney(bet);
    }

    @Override
    public void call() {

    }

    public boolean isStillInTheGame() {
        return stillInTheGame;
    }

    public void setStillInTheGame(boolean stillInTheGame) {
        this.stillInTheGame = stillInTheGame;
    }

}
