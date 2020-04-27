package game.card;

public class TwoCardsInPlayersHands {


    public TwoCardsInPlayersHands(Card cardOne, Card cardTwo) {
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
    }

    private Card cardOne;
    private Card cardTwo;

    public Card getCardOne() {
        return cardOne;
    }

    public Card getCardTwo() {
        return cardTwo;
    }



    @Override
    public String toString() {
        return "TwoCardsInPlayersHands{" +
                "cardOne=" + cardOne +
                ", cardTwo=" + cardTwo +
                '}';
    }
}
