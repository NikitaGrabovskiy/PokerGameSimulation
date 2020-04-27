package player;

import game.card.TwoCardsInPlayersHands;

public interface Player {

    void playPreFlopRound();

    void playFlopRound();

    void playTurnRound();

    void playRiverRound();

    void fold();

    void raise();

    void call();

    void deductAmountFromPlayersMoney(int deductionAmount);

    int getMoneyAmount();

    void setMoneyAmount(int moneyAmount);

    TwoCardsInPlayersHands getTwoCardsInPlayersHands();

    void setTwoCardsInPlayersHands(TwoCardsInPlayersHands twoCardsInPlayersHands);

}
