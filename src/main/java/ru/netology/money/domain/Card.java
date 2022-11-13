package ru.netology.money.domain;

public class Card {
    String cardNumber;
    String cardValidTill;
    String cardCVV;
    int cardValue;
    String cardCurrency;

    public String getCardNumber(){
        return this.cardNumber;
    }
    public String getCardValidTill(){
        return this.cardValidTill;
    }
    public String getCardCVV(){
        return this.cardCVV;
    }


    public int getCardValue(){
        return this.cardValue;
    }

    public void depositCard(int value){
        this.cardValue = this.cardValue + value;
    }

    public void paymentCard(int value){
        this.cardValue = this.cardValue - value;
    }

    public boolean checkCardBalance(Amount amount){
        boolean res = false;
        if(this.cardCurrency.equals(amount.getCurrency())&&(this.cardValue >= amount.getValue())) res = true;
        return res;
    }

    public void setCardValue(int cardValue){
        this.cardValue = cardValue;
    }

    public Card() {
    }

    public Card(String cardNumber, String cardValidTill, String cardCVV, int cardValue, String cardCurrency) {
        this.cardNumber = cardNumber;
        this.cardValidTill = cardValidTill;
        this.cardCVV = cardCVV;
        this.cardValue = cardValue;
        this.cardCurrency = cardCurrency;
    }
}
