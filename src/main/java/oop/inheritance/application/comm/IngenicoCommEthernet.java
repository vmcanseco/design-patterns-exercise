package oop.inheritance.application.comm;

import oop.inheritance.application.ITransaction;
import oop.inheritance.application.ITransactionResponse;
import oop.inheritance.application.IngenicoTransaction;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.services.IngenicoEthernet;

public class IngenicoCommEthernet extends IngenicoEthernet implements  ICommunication {

    @Override
    public void fopen() {
        super.open();
    }

    @Override
    public void fsend(ITransaction transaction) {
        super.send((IngenicoTransaction) transaction);
    }

    @Override
    public ITransactionResponse freceive() {
        return null;
    }

    @Override
    public void fclose() {
        super.close();
    }
}
