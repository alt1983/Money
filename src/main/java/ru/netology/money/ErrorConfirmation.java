package ru.netology.money;

public class ErrorConfirmation extends RuntimeException {
    public ErrorConfirmation(String msg) {
        super(msg);
    }
}