package oop.inheritance.application.display;

import oop.library.v240m.VerifoneV240mDisplay;

public class DisplayVerifone  implements IDisplay {
    private  VerifoneV240mDisplay display;
    private static  DisplayVerifone uniqueInstance;
    public DisplayVerifone(){
        display = new VerifoneV240mDisplay();
    }

    @Override
    public void clear() {
        display.clear();
    }

    @Override
    public void showMessage(int x, int y, String message) {
        display.print(x,y,message);
    }

    public static  DisplayVerifone getInstance(){
        if (uniqueInstance ==null){
            synchronized (DisplayVerifone.class) {
                if (uniqueInstance ==null) {
                    uniqueInstance = new DisplayVerifone();
                }
            }
        }
        return uniqueInstance;
    }
}
