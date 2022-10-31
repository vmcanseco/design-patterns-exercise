package oop.inheritance.application.factory;

import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;

public interface IPeripheralFactory {

    IDisplay createDisplay();
    IKeyboard createKeyboard();
}
