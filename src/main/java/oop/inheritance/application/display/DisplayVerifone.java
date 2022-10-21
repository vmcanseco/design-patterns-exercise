package oop.inheritance.application.display;

import oop.library.ingenico.services.IngenicoDisplay;
import oop.library.v240m.VerifoneV240mDisplay;

public class DisplayVerifone extends VerifoneV240mDisplay implements IDisplay {
    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void showMessage(int x, int y, String message) {
        super.print(x,y,message);
    }
}
