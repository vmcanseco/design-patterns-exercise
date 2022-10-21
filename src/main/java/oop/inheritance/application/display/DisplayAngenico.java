package oop.inheritance.application.display;

import oop.library.ingenico.services.IngenicoDisplay;

public class DisplayAngenico extends IngenicoDisplay implements IDisplay {
    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void showMessage(int x, int y, String message) {
        super.showMessage(x,y,message);
    }
}
