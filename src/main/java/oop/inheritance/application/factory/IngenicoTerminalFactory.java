package oop.inheritance.application.factory;

import oop.inheritance.application.comm.ICommunication;
import oop.inheritance.application.comm.IngenicoCommEthernet;
import oop.inheritance.application.comm.IngenicoCommGPS;
import oop.inheritance.application.comm.IngenicoCommModem;
import oop.inheritance.application.printer.IPrinter;
import oop.inheritance.application.printer.PrinterIngenico;
import oop.inheritance.application.readers.ChipReaderIngenico;
import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.transaction.IngenicoTransaction;
import oop.inheritance.application.display.DisplayIngenico;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.keyboard.KeyboardIngenico;
import oop.inheritance.application.readers.ICardReader;
import oop.inheritance.application.readers.SwipperReaderIngenico;
import oop.library.ingenico.services.IngenicoPrinter;

import java.util.Arrays;
import java.util.List;

public class IngenicoTerminalFactory extends AbstractTerminalFactory {

    private String communicationType;

    public IngenicoTerminalFactory(String communicationType){
        this.communicationType = communicationType;
    }

    @Override
    public IDisplay createDisplay() {
        return  DisplayIngenico.getInstance();
    }

    @Override
    public IKeyboard createKeyboard() {
        return KeyboardIngenico.getInstance();
    }

    @Override
    public List<ICardReader> createCardReaders() {
        return Arrays.asList(SwipperReaderIngenico.getInstance(), ChipReaderIngenico.getInstance());
    }

    @Override
    public ITransaction createTransaction() {
        return new IngenicoTransaction();
    }

    @Override
    public ICommunication createCommunication() {
        switch (communicationType){
            case "ETHERNET":
                return new IngenicoCommEthernet();
            case "GPS":
                return new IngenicoCommGPS();
            case "MODEM":
                return new IngenicoCommModem();
            default:
                throw new UnsupportedOperationException("Invalid Communication Method");
        }
    }

    @Override
    public IPrinter createPrinter() {
        return PrinterIngenico.getInstance();
    }
}
