package oop.inheritance.application.factory;

import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.keyboard.IKeyboard;
import oop.inheritance.application.readers.ICardReader;

public interface IPeripheralFactory {

    IDisplay createDisplay();
    IKeyboard createKeyboard();
    ICardReader createCardReader();
}
