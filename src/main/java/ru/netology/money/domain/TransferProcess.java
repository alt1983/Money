package ru.netology.money.domain;

public class TransferProcess {
    private Transfer transfer;
    private int transferId;
    private String status;
    private String code;

    public TransferProcess() {
    }

    public TransferProcess(Transfer transfer, int transferId, String status, String code) {
        this.transfer = transfer;
        this.transferId = transferId;
        this.status = status;
        this.code = code;
    }

    public Transfer getTransfer() {
        return this.transfer;
    }

    public int getTransferId() {
        return transferId;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
