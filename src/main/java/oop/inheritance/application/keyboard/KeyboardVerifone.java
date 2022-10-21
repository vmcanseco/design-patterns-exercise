package oop.inheritance.application.keyboard;

import oop.library.v240m.VerifoneV240mKeyboard;

public class KeyboardVerifone extends VerifoneV240mKeyboard implements IKeyboard {
    @Override
    public String readKeyChar() {
        return "K";
    }

    @Override
    public String readKeyLine() {
        return "12.31";
    }
}
