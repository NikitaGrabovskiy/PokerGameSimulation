package player;

import game.card.TwoCardsInPlayersHands;

public class ComputerPlayer implements Player {

    private TwoCardsInPlayersHands twoCardsInPlayersHands;

    public TwoCardsInPlayersHands getTwoCardsInPlayersHands() {
        return twoCardsInPlayersHands;
    }

    public void setTwoCardsInPlayersHands(TwoCardsInPlayersHands twoCardsInPlayersHands) {
        this.twoCardsInPlayersHands = twoCardsInPlayersHands;
    }

    private int moneyAmount;

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
