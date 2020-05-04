package game.card;

import java.util.ArrayList;
import java.util.List;

public class TwoCardsInPlayersHands {

    private List<Card> cards;

    public TwoCardsInPlayersHands(Card cardOne, Card cardTwo) {
        cards = new ArrayList<>();
        cards.add(cardOne);
        cards.add(cardTwo);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return ""+cards;
    }
}
