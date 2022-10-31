package oop.inheritance.application.display;

import oop.library.ingenico.services.IngenicoDisplay;

public class DisplayIngenico implements IDisplay {

    private IngenicoDisplay display;
    private static DisplayIngenico uniqueInstance;

    private DisplayIngenico() {
        display = new IngenicoDisplay();
    }

    @Override
    public void clear() {
        display.clear();
    }

    @Override
    public void showMessage(int x, int y, String message) {
        display.showMessage(x, y, message);
    }

    public static  DisplayIngenico getInstance(){
        if (uniqueInstance==null){
            synchronized (DisplayIngenico.class) {
                if (uniqueInstance==null) {
                    uniqueInstance = new DisplayIngenico();
                }
            }
        }
        return uniqueInstance;
    }
}
