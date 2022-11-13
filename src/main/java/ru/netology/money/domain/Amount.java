package ru.netology.money.domain;

public class Amount {

    private Integer value;
    private String currency;

    public Amount(){
    }

    public Amount(Integer value, String currency){
        this.value = value;
        this.currency = currency;
    }

    public Integer getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
