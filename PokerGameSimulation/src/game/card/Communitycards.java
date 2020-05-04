package game.card;

public class Communitycards {

    public Communitycards(Card cardOne, Card cardTwo, Card cardThree) {
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
        this.cardThree = cardThree;
    }

    private Card cardOne;
    private Card cardTwo;
    private Card cardThree;
    private Card cardFour;
    private Card cardFive;

    public Card getCardOne() {
        return cardOne;
    }

    public Card getCardTwo() {
        return cardTwo;
    }

    public Card getCardThree() {
        return cardThree;
    }


    public Card getCardFour() {
        return cardFour;
    }

    public void setCardFour(Card cardFour) {
        this.cardFour = cardFour;
    }

    public Card getCardFive() {
        return cardFive;
    }

    public void setCardFive(Card cardFive) {
        this.cardFive = cardFive;
    }


    @Override
    public String toString() {
        return
                "     " + cardOne +
                        "     " + cardTwo +
                        "     " + cardThree +
                        "     " + cardFour +
                        "     " + cardFive;
    }
}
