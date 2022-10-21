package oop.inheritance.application.keyboard;

import oop.library.ingenico.services.IngenicoKeyboard;

public class KeyboardAngenico extends IngenicoKeyboard implements IKeyboard {

    @Override
    public String readKeyChar() {
        return super.getChar();
    }

    @Override
    public String readKeyLine() {
        return super.readLine();
    }
}
