package oop.inheritance.application.keyboard;

import oop.library.v240m.VerifoneV240mKeyboard;

public class KeyboardVerifone implements IKeyboard {

    private VerifoneV240mKeyboard keyboard;
    private static  KeyboardVerifone uniqueInstance;
    public  KeyboardVerifone(){
        keyboard = new VerifoneV240mKeyboard();
    }

    @Override
    public String getChar() {
        return keyboard.get();
    }

    @Override
    public String readLine() {
        return keyboard.get();
    }

    public static KeyboardVerifone getInstance(){
        if (uniqueInstance==null){
            synchronized (KeyboardVerifone.class){
                if (uniqueInstance==null){
                    uniqueInstance = new KeyboardVerifone();
                }
            }
        }
        return  uniqueInstance;
    }
}
