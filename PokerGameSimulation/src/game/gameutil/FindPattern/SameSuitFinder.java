package game.gameutil.FindPattern;

import game.card.Card;
import game.card.Suit;
import game.card.hands.Flush;
import game.gameutil.staticdata.RanksValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SameSuitFinder {

    public Flush findFlush(Card [] cards){

        if(findNumberOfCardsOfGivenSuit(Suit.CLUBS,cards)>=5){
            return createFlushFromCards(Suit.CLUBS,cards);
        }else if(findNumberOfCardsOfGivenSuit(Suit.DIAMONDS,cards)>=5){
            return createFlushFromCards(Suit.DIAMONDS,cards);
        }else if(findNumberOfCardsOfGivenSuit(Suit.HEARTS,cards)>=5){
            return createFlushFromCards(Suit.HEARTS,cards);
        }else if(findNumberOfCardsOfGivenSuit(Suit.SPADES,cards)>=5){
            return createFlushFromCards(Suit.SPADES,cards);
        }

        return null;

    }


    public int findNumberOfCardsOfGivenSuit(Suit suit, Card[] cards) {

        int countOfSameSuitCards = 0;

        for (int x = 0; x < cards.length; x++) {
            if (cards[x].getSuit().equals(suit)) {
                countOfSameSuitCards++;
            }
        }
        return countOfSameSuitCards;
    }

    private Flush createFlushFromCards(Suit suit,Card [] cards){

        List<Card> listOfCards =Arrays.asList(cards)
                .stream()
                .filter(a ->a.getSuit().equals(suit))
                .collect(Collectors.toList());



        while (listOfCards.size()>5){
            listOfCards.remove(listOfCards.stream().min((a, b) -> RanksValue.rankValues.get(a.getRank()).compareTo(RanksValue.rankValues.get(b.getRank()))).get());
        }

        Card [] flushArray = new Card[5];

        Flush flush = new Flush(listOfCards.toArray(flushArray));
        return flush;
    }


}
