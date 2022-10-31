package oop.inheritance.application.comm;

import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.transaction.ITransactionResponse;

public class IngenicoCommModem implements ICommunication {
    @Override
    public void fopen() {

    }

    @Override
    public void fsend(ITransaction transaction) {

    }

    @Override
    public ITransactionResponse freceive() {
        return null;
    }

    @Override
    public void fclose() {

    }
}
