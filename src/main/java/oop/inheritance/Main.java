package oop.inheritance;

import oop.inheritance.application.*;
import oop.inheritance.application.factory.AbstractTerminalFactory;
import oop.inheritance.application.factory.IngenicoTerminalFactory;
import oop.inheritance.application.factory.VerifoneTerminalFactory;
import oop.inheritance.data.SupportedTerminal;


public class Main {

    /*public static IApplication configureApplication(String terminal) throws Exception {
        IApplication application;
        SupportedTerminal supportedTerminal = SupportedTerminal.valueOf(terminal);
        if (supportedTerminal == SupportedTerminal.INGENICO) {
            application = new ApplicationIngenicoImpl(new IngenicoTerminalFactory());
        } else if (supportedTerminal == SupportedTerminal.VERIFONE) {
            application = new ApplicationVerifoneImpl(new VerifoneTerminalFactory());
        } else {
            throw new Exception("Invalid terminal");
        }
        return application;
    }*/

    public static void main(String[] args) throws Exception {
        String terminal = args[0];
        String communicationType=args[1];
        Application application = new Application(AbstractTerminalFactory.createTerminalFactory(terminal,communicationType));

        while (true) {
            run(application);
        }
    }

    public static void run(Application application) {
        application.clearScreen();
        application.showMenu();

        String key = application.readKey();

        switch (key) {
            case "1":
                application.doSale();
                break;
            case "2":
                application.doRefund();
                break;
            case "3":
                application.printReport();
                break;
            case "4":
                application.showConfiguration();
                break;
        }
    }

}
