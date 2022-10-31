package oop.inheritance.application.keyboard;

import oop.library.ingenico.services.IngenicoKeyboard;

public class KeyboardIngenico implements IKeyboard {

    private IngenicoKeyboard keyboard;
    private static KeyboardIngenico uniqueInstance;

    public KeyboardIngenico(){
        keyboard = new IngenicoKeyboard();
    }
    @Override
    public String getChar() {
      return keyboard.getChar();
    }

    @Override
    public String readLine() {
        return keyboard.readLine();
    }

    public static KeyboardIngenico getInstance(){
        if (uniqueInstance==null){
            synchronized (KeyboardIngenico.class){
                if (uniqueInstance==null){
                    uniqueInstance = new KeyboardIngenico();
                }
            }
        }
        return uniqueInstance;
    }
}
