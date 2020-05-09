package player;

import game.card.TwoCardsInPlayersHands;

public interface Player {

    void playPreFlopRound();

    void playFlopRound();

    void playTurnRound();

    void playRiverRound();

    void fold();

    void raise(int bet);

    void call();

    void deductAmountFromPlayersMoney(int deductionAmount);

    int getMoneyAmount();

    void setMoneyAmount(int moneyAmount);

    TwoCardsInPlayersHands getTwoCardsInPlayersHands();

    void setTwoCardsInPlayersHands(TwoCardsInPlayersHands twoCardsInPlayersHands);

    boolean isStillInTheGame();

    void setStillInTheGame(boolean stillInTheGame);

    String getName();

    void setName(String name);

    int getNumber();

    void setNumber(int number);

    void addToMoneyAmount(int winnings);

}
