package ru.netology.money;

public class ErrorTransfer extends RuntimeException {
    public ErrorTransfer(String msg) {
        super(msg);
    }
}
