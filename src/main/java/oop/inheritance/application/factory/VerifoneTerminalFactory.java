package oop.inheritance.application.factory;

import oop.inheritance.application.display.DisplayVerifone;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.keyboard.KeyboardVerifone;

public class VerifoneTerminalFactory extends AbstractTerminalFactory {

    @Override
    public IDisplay createDisplay() {
        return DisplayVerifone.getInstance();
    }

    @Override
    public IKeyboard createKeyboard() {
        return KeyboardVerifone.getInstance();
    }
}
