package ru.netology.money;

import org.junit.Assert;
import org.junit.Rule;
//import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import ru.netology.money.domain.*;

@SpringBootTest
class MoneyApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void getTransferDataTest() {
        Transfer transfer = Mockito.mock(Transfer.class);
        Mockito.when(transfer.getCardFromNumber()).thenReturn("1111111111111111");
        Mockito.when(transfer.getCardToNumber()).thenReturn("2222222222222222");
        Mockito.when(transfer.getCardFromCVV()).thenReturn("111");
        Mockito.when(transfer.getCardFromValidTill()).thenReturn("12/23");
        Mockito.when(transfer.getAmount()).thenReturn(new Amount(100000, "RUR"));
        CardRepository cardRepository = new CardRepository();
        TransferRepository transferRepository = new TransferRepository();
        MoneyService service = new MoneyService(cardRepository, transferRepository);
        Assert.assertNotNull(service.getTransfer(transfer));
        Assert.assertEquals(service.getTransfer(transfer).getClass(), String.class);
    }

    @Test
    void getTransferErrorTransferTest() {

        boolean errorTransfer = false;

        Transfer transfer = Mockito.mock(Transfer.class);
        Mockito.when(transfer.getCardFromNumber()).thenReturn("1111111111111111");
        Mockito.when(transfer.getCardToNumber()).thenReturn("2222222222222222");
        Mockito.when(transfer.getCardFromCVV()).thenReturn("000");
        Mockito.when(transfer.getCardFromValidTill()).thenReturn("12/23");
        Mockito.when(transfer.getAmount()).thenReturn(new Amount(100000, "RUR"));

        CardRepository cardRepository = new CardRepository();
        TransferRepository transferRepository = new TransferRepository();
        MoneyService service = new MoneyService(cardRepository, transferRepository);

        try {
            String res = service.getTransfer(transfer);
        } catch (ErrorTransfer e) {
            errorTransfer = true;
        }

        Assert.assertTrue(errorTransfer);

    }

    @Test
    void getTransferErrorInputDataTest() {

        boolean errorInputData = false;

        CardRepository cardRepository = new CardRepository();
        TransferRepository transferRepository = new TransferRepository();
        MoneyService service = new MoneyService(cardRepository, transferRepository);
        Transfer transfer = new Transfer();
        try {
            String res = service.getTransfer(transfer);
        } catch (ErrorInputData e) {
            errorInputData = true;
        }

        Assert.assertTrue(errorInputData);

    }

    @Test
    void getConfirmOperationErrorInputDataTest() {

        boolean errorInputData = false;

        CardRepository cardRepository = new CardRepository();
        TransferRepository transferRepository = new TransferRepository();
        MoneyService service = new MoneyService(cardRepository, transferRepository);
        Confirmation confirmation = new Confirmation();
        try {
            String res = service.getConfirmOperation(confirmation);
        } catch (ErrorInputData e) {
            errorInputData = true;
        }

        Assert.assertTrue(errorInputData);

    }

    @Test
    void getConfirmOperationErrorConfirmationTest() {
        Confirmation confirmation = Mockito.mock(Confirmation.class);
        Mockito.when(confirmation.getOperationId()).thenReturn("0");
        Mockito.when(confirmation.getCode()).thenReturn("1111");
        CardRepository cardRepository = new CardRepository();
        TransferRepository transferRepository = new TransferRepository();
        MoneyService service = new MoneyService(cardRepository, transferRepository);

        boolean errorConfirmation = false;

        try {
            String res = service.getConfirmOperation(confirmation);
        } catch (ErrorConfirmation e) {
            errorConfirmation = true;
        }

        Assert.assertTrue(errorConfirmation);

    }

    @Test
    void getConfirmOperationDataTest() {
        Confirmation confirmation = Mockito.mock(Confirmation.class);
        Mockito.when(confirmation.getOperationId()).thenReturn("1");
        Mockito.when(confirmation.getCode()).thenReturn("0000");
        CardRepository cardRepository = new CardRepository();
        TransferRepository transferRepository = new TransferRepository();
        MoneyService service = new MoneyService(cardRepository, transferRepository);
        Assert.assertNotNull(service.getConfirmOperation(confirmation));
    }

}
