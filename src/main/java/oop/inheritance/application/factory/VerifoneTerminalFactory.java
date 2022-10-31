package oop.inheritance.application.factory;

import oop.inheritance.application.comm.ICommunication;
import oop.inheritance.application.printer.IPrinter;
import oop.inheritance.application.printer.PrinterVerifone;
import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.display.DisplayVerifone;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.keyboard.KeyboardVerifone;
import oop.inheritance.application.readers.ICardReader;

import java.util.List;

public class VerifoneTerminalFactory extends AbstractTerminalFactory {

    private String communicationType;

    public VerifoneTerminalFactory(String communicationType){
        this.communicationType=communicationType;
    }

    @Override
    public IDisplay createDisplay() {
        return DisplayVerifone.getInstance();
    }

    @Override
    public IKeyboard createKeyboard() {
        return KeyboardVerifone.getInstance();
    }

    @Override
    public List<ICardReader> createCardReaders() {
        return null;
    }

    @Override
    public ITransaction createTransaction() {
        return null;
    }

    @Override
    public ICommunication createCommunication() {
        return null;
    }

    @Override
    public IPrinter createPrinter() {
        return PrinterVerifone.getInstance();
    }
}
