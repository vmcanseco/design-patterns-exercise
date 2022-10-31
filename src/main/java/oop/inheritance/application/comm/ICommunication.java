package oop.inheritance.application.comm;

import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.transaction.ITransactionResponse;

public interface ICommunication {
    void fopen();
    void fsend(ITransaction transaction);
    ITransactionResponse freceive();
    void fclose();

}
