package oop.inheritance.application.factory;

import oop.inheritance.application.display.DisplayVerifone;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.keyboard.KeyboardVerifone;

public class VerifonePeripheralFactory implements  PeripheralFactory{
    private DisplayVerifone displayVerifone;
    private KeyboardVerifone keyboardVerifone;
    @Override
    public IDisplay createDisplay() {

        return displayVerifone == null ? new DisplayVerifone():displayVerifone;
    }

    @Override
    public IKeyboard createKeyboard() {
        return keyboardVerifone == null ? new KeyboardVerifone() : keyboardVerifone;
    }
}
