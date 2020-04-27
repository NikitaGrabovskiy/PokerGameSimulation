package game.card;

public class ShuffledDeck {

    int nextCardNumber = 0;

    public ShuffledDeck(Card [] cards){
        this.cards = cards;
    }

    private Card [] cards;

    public Card getNextCard(){
        Card card = cards [nextCardNumber];
        nextCardNumber++;
        return card;
    }
}
