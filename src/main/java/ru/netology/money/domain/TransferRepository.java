package ru.netology.money.domain;

import java.util.ArrayList;
import java.util.List;

public class TransferRepository {
    private List<TransferProcess> transfers;

    public TransferRepository() {
        transfers = new ArrayList<>();
        Transfer t = new Transfer("1111111111111111", "12/23", "111", "2222222222222222", new Amount(1000, "RUR"));
        this.addTransferProcess(new TransferProcess(t, 1, "REQUESTED", "0000"));
    }

    public TransferProcess getTransferById(int id) {
        TransferProcess transferProcess = null;
        for (TransferProcess t : transfers) {
            if (t.getTransferId() == id) {
                transferProcess = t;
            }
        }
        return transferProcess;
    }

    public String addTransferProcess(TransferProcess transferProcess) {
        int id = 1;
        for (TransferProcess t : transfers) {
            if (t.getTransferId() >= id) {
                id = t.getTransferId() + 1;
            }
        }

        transferProcess.setTransferId(id);
        transfers.add(transferProcess);
        return String.valueOf(id);
    }
}
