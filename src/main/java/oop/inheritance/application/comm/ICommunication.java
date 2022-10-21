package oop.inheritance.application.comm;

import oop.inheritance.application.ITransaction;
import oop.inheritance.application.ITransactionResponse;

public interface ICommunication {
    void fopen();
    void fsend(ITransaction transaction);
    ITransactionResponse freceive();
    void fclose();

}
