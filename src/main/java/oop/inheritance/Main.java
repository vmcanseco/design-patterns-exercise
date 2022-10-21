package oop.inheritance;

import oop.inheritance.application.*;
import oop.inheritance.application.factory.IngenicoPeripheralFactory;
import oop.inheritance.application.factory.VerifonePeripheralFactory;
import oop.inheritance.data.SupportedTerminal;

import java.util.List;

interface Card{
    void process();
}
@FunctionalInterface
interface Provider{
    void readCard(Card card);
}

  class CardProvider{
      void readCard(Provider provider) {

      }
  }

public class Main {

    public static IApplication configureApplication(String terminal) throws Exception {
        IApplication application;
        SupportedTerminal supportedTerminal = SupportedTerminal.valueOf(terminal);
        if (supportedTerminal == SupportedTerminal.INGENICO) {
            application = new ApplicationIngenicoImpl(new IngenicoPeripheralFactory());
        } else if (supportedTerminal == SupportedTerminal.VERIFONE) {
            application = new ApplicationVerifoneImpl(new VerifonePeripheralFactory());
        } else {
            throw new Exception("Invalid terminal");
        }
        return application;
    }

    public static void main(String[] args) throws Exception {
        /*IApplication application = configureApplication(args[0]);

        while (true) {
            run(application);
        }*/

        CardProvider cardProvider=new CardProvider();
        cardProvider.readCard(card -> {
            System.out.println("Hola");
        });

    }

    public static void run(IApplication application) {
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
