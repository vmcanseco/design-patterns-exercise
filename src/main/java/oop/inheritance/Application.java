package oop.inheritance;

import java.time.LocalDateTime;
import java.util.List;

import oop.inheritance.application.comm.ICommunication;
import oop.inheritance.application.printer.IPrinter;
import oop.inheritance.application.readers.ICardConsumer;
import oop.inheritance.application.readers.ICardProvider;
import oop.inheritance.application.transaction.ITransaction;
import oop.inheritance.application.transaction.ITransactionResponse;
import oop.inheritance.application.transaction.IngenicoTransaction;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.factory.AbstractTerminalFactory;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.model.ICard;
import oop.inheritance.application.readers.ICardReader;
import oop.library.ingenico.services.*;

public class Application{

    //private CommunicationType communicationType = CommunicationType.ETHERNET;

    private AbstractTerminalFactory terminalFactory;

    public Application(AbstractTerminalFactory peripheralFactory){
        this.terminalFactory = peripheralFactory;

    }

    public void showMenu() {
        IDisplay display = terminalFactory.createDisplay();

        display.showMessage(5, 5, "MENU");
        display.showMessage(5, 10, "1. VENTA");
        display.showMessage(5, 13, "2. DEVOLUCION");
        display.showMessage(5, 16, "3. REPORTE");
        display.showMessage(5, 23, "4. CONFIGURACION");

    }

    public String readKey() {
        IKeyboard keyboard = terminalFactory.createKeyboard();
        return keyboard.getChar();
    }

    public void doSale() {
        /*IngenicoCardSwipper cardSwipper = new IngenicoCardSwipper();
        IngenicoChipReader chipReader = new IngenicoChipReader();*/
        IDisplay ingenicoDisplay = terminalFactory.createDisplay();
        IKeyboard ingenicoKeyboard = terminalFactory.createKeyboard();
        List<ICardReader> cardReaders = terminalFactory.createCardReaders();
        /*Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);*/

        ICardProvider cardProvider = terminalFactory.createCardProvider();

        cardProvider.readCard(new ICardConsumer() {
            @Override
            public void consumeCard(ICard card, String value) {

            }
        })

        cardProvider.readCard((card,val) -> {

            ingenicoDisplay.clear();
            ingenicoDisplay.showMessage(5, 20, "Capture monto:");

            String amount = ingenicoKeyboard.readLine(); //Amount with decimal point as string

            //Transaction transaction = new Transaction();
            ITransaction transaction = terminalFactory.createTransaction();

            transaction.setLocalDateTime(LocalDateTime.now());
            transaction.setCard(card);
            transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

            ITransactionResponse response = sendSale(transaction);

            if (response.isApproved()) {
                ingenicoDisplay.showMessage(5, 25, "APROBADA");
                printReceipt(transaction, response.getHostReference());
            } else {
                ingenicoDisplay.showMessage(5, 25, "DENEGADA");
            }
        });

        for (ICardReader cardReader:cardReaders){
            if (cardReader!=null){
                ICard card = cardReader.readCard();

                ingenicoDisplay.clear();
                ingenicoDisplay.showMessage(5, 20, "Capture monto:");

                String amount = ingenicoKeyboard.readLine(); //Amount with decimal point as string

                //Transaction transaction = new Transaction();
                ITransaction transaction = terminalFactory.createTransaction();

                transaction.setLocalDateTime(LocalDateTime.now());
                transaction.setCard(card);
                transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

                ITransactionResponse response = sendSale(transaction);

                if (response.isApproved()) {
                    ingenicoDisplay.showMessage(5, 25, "APROBADA");
                    printReceipt(transaction, response.getHostReference());
                } else {
                    ingenicoDisplay.showMessage(5, 25, "DENEGADA");
                }
                break;
            }
        }

    }

    private void printReceipt(ITransaction transaction, String hostReference) {
        IPrinter ingenicoPrinter = terminalFactory.createPrinter();
        ICard card = transaction.getCard();

        ingenicoPrinter.print(5, "APROBADA");
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, card.getAccount());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "" + transaction.getAmountInCents());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "________________");

    }

    private ITransactionResponse sendSale(ITransaction transaction) {
        ICommunication communication = terminalFactory.createCommunication();
        communication.fopen();
        communication.fsend(transaction);
        ITransactionResponse transactionResponse = communication.freceive();
        communication.fclose();
        return  transactionResponse;
        /*IngenicoEthernet ethernet = new IngenicoEthernet();
        IngenicoModem modem = new IngenicoModem();
        IngenicoGPS gps = new IngenicoGPS();
        TransactionResponse transactionResponse = null;

        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }*/
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
       IDisplay display = terminalFactory.createDisplay();
       display.clear();
    }
}
