package oop.inheritance.application.factory;

import oop.inheritance.application.comm.ICommunication;
import oop.inheritance.application.printer.IPrinter;
import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.readers.ICardReader;

import java.util.List;

public abstract class AbstractTerminalFactory {
    private String communcationType;
    public abstract IDisplay createDisplay();
    public abstract IKeyboard createKeyboard();
    public abstract List<ICardReader> createCardReaders();
    public abstract ITransaction createTransaction();
    public abstract ICommunication createCommunication();
    public abstract IPrinter createPrinter();

    public static AbstractTerminalFactory createTerminalFactory(String terminal,String communicationType){
        switch (terminal){
            case "INGENICO":
                return new IngenicoTerminalFactory(communicationType);
            case "VERIFONE":
                return new VerifoneTerminalFactory(communicationType);
            default:
                throw new UnsupportedOperationException("Invalid terminal");
        }
    }
}