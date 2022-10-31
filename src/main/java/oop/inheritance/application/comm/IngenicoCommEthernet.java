package oop.inheritance.application.comm;

import oop.inheritance.application.transaction.BaseTransactionResponse;
import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.transaction.ITransactionResponse;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.ExpirationDate;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoEthernet;

public class IngenicoCommEthernet implements  ICommunication {
    IngenicoEthernet ingenicoEthernet;

    public IngenicoCommEthernet(){
        ingenicoEthernet=new IngenicoEthernet();
    }

    @Override
    public void fopen() {
        ingenicoEthernet.open();
    }

    @Override
    public void fsend(ITransaction transaction) {
        Transaction transaction1 = new Transaction();
        transaction1.setAmountInCents(transaction.getAmountInCents());
        transaction1.setLocalDateTime(transaction.getLocalDateTime());

        Card card =  Card.builder().account(transaction.getCard().getAccount())
                .expirationDate(ExpirationDate.builder().year(transaction.getCard().getExpirationDate().getYear())
                        .year(transaction.getCard().getExpirationDate().getYear()).build()).build();

        transaction1.setCard(card);

        ingenicoEthernet.send(transaction1);
    }

    @Override
    public ITransactionResponse freceive() {
        TransactionResponse response=ingenicoEthernet.receive();
        return new BaseTransactionResponse(response.isApproved(),response.getHostReference());
    }

    @Override
    public void fclose() {
        ingenicoEthernet.close();
    }
}
