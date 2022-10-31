package oop.inheritance.application.factory;

import oop.inheritance.application.display.DisplayIngenico;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.keyboard.KeyboardIngenico;

public class IngenicoTerminalFactory extends AbstractTerminalFactory {

    @Override
    public IDisplay createDisplay() {
        return  DisplayIngenico.getInstance();
    }

    @Override
    public IKeyboard createKeyboard() {
        return KeyboardIngenico.getInstance();
    }
}
