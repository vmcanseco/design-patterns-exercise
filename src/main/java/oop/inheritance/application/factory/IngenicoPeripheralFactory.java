package oop.inheritance.application.factory;

import oop.inheritance.application.display.DisplayAngenico;
import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.keyboard.KeyboardAngenico;

public class IngenicoPeripheralFactory implements PeripheralFactory{
    private DisplayAngenico displayAngenico;
    private KeyboardAngenico keyboardAngenico;

    @Override
    public IDisplay createDisplay() {
        return  displayAngenico == null ? new DisplayAngenico():displayAngenico;
    }

    @Override
    public IKeyboard createKeyboard() {
        return  keyboardAngenico ==null ? new KeyboardAngenico():keyboardAngenico;
    }
}
