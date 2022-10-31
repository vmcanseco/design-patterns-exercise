package oop.inheritance.application.factory;

import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;

public abstract class AbstractTerminalFactory {

    public abstract IDisplay createDisplay();
    public abstract IKeyboard createKeyboard();

    public static AbstractTerminalFactory createTerminalFactory(String terminal){
        switch (terminal){
            case "INGENICO":
                return new IngenicoTerminalFactory();
            case "VERIFONE":
                return new VerifoneTerminalFactory();
            default:
                throw new UnsupportedOperationException("Invalid terminal");
        }
    }
}
