package ru.netology.money;

import ru.netology.money.domain.*;

import java.util.List;

public class MoneyService {

    private CardRepository cardRepository;
    private TransferRepository transferRepository;

    public MoneyService(CardRepository cardRepository, TransferRepository transferRepository) {
        this.cardRepository = cardRepository;
        this.transferRepository = transferRepository;
    }

    public String getTransfer(Transfer transfer) {

        if (isEmpty(transfer.getCardFromNumber()) || isEmpty(transfer.getCardFromCVV()) || isEmpty(transfer.getCardToNumber()) || isEmpty(transfer.getCardFromValidTill())
                || (transfer.getAmount() == null) || isEmpty(transfer.getAmount().getCurrency()) || (transfer.getAmount().getValue() == null) || (transfer.getAmount().getValue() <= 0)) {
            System.out.println("ErrorInputData");
            throw new ErrorInputData("Error input data");
        }

        String res = null;

        if ((cardRepository.getCardById(transfer.getCardToNumber()) != null) && (cardRepository.getCardById(transfer.getCardFromNumber()) != null)
                && (cardRepository.getCardById(transfer.getCardFromNumber()).getCardCVV().equals(transfer.getCardFromCVV()))
                && (cardRepository.getCardById(transfer.getCardFromNumber()).getCardValidTill().equals(transfer.getCardFromValidTill()))
                && (cardRepository.getCardById(transfer.getCardFromNumber()).checkCardBalance(transfer.getAmount()))) {
            res = transferRepository.addTransferProcess(new TransferProcess(transfer, 0, "REQUESTED", "0000"));
        }

        if (res == null) {
            System.out.println("ErrorTransfer");
            throw new ErrorTransfer("ErrorTransfer");
        }

        return res;
    }

    public String getConfirmOperation(Confirmation confirmation) {

        if (isEmpty(confirmation.getCode()) || isEmpty(confirmation.getOperationId())) {
            System.out.println("ErrorInputData");
            throw new ErrorInputData("Error input data");
        }

        String res = null;

        TransferProcess transferProcess = transferRepository.getTransferById(Integer.parseInt(confirmation.getOperationId()));

        if ((transferProcess != null) && transferProcess.getCode().equals(confirmation.getCode()) && transferProcess.getStatus().equals("REQUESTED")) {
            transferProcess.setStatus("CONFIRMED");
            cardRepository.getCardById(transferProcess.getTransfer().getCardFromNumber()).paymentCard(transferProcess.getTransfer().getAmount().getValue());
            cardRepository.getCardById(transferProcess.getTransfer().getCardToNumber()).depositCard(transferProcess.getTransfer().getAmount().getValue());
            res = confirmation.getOperationId();
        }

        if (res == null) {
            System.out.println("ErrorConfirmation");
            throw new ErrorConfirmation("ErrorConfirmation");
        }

        return res;
    }

    private boolean isEmpty(String str) {
        boolean res = false;
        if ((str == null) || str.equals("")) res = true;
        return res;
    }


}
