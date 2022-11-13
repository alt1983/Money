package ru.netology.money.domain;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {

    private List<Card> cards;

    public CardRepository(){
        cards = new ArrayList<>();
        this.addCard("1111111111111111", "12/23", "111", 100000, "RUR");
        this.addCard("2222222222222222", "12/23", "222", 100000, "RUR");
        this.addCard("3333333333333333", "12/23", "333", 100000, "RUR");
    }

    public Card getCardById(String id){

        Card card = null;

        for(Card c: cards){
            if(c.getCardNumber().equals(id)){
                card = c;
            }
        }
        return card;
    }


    public void addCard(String cardNumber, String cardValidTill, String cardCVV, int cardValue, String cardCurrency){

        Card card = null;
        int i = -1;

        for(Card c: cards){
            if(c.getCardNumber().equals(cardNumber)){
                card = c;
            }
        }

        if(card == null){
            card = new Card(cardNumber, cardValidTill, cardCVV, cardValue, cardCurrency);
            this.cards.add(card);
        }

    }

}
