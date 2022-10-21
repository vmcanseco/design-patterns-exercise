package oop.inheritance.application.printer;

import oop.library.v240m.VerifoneV240mPrinter;

public class VerifonePrinter extends VerifoneV240mPrinter implements IPrinter {
    @Override
    public void fprint(int x, String message) {
        super.print(x,message);
    }

    @Override
    public void flinefeed() {
        super.lineFeed();
    }
}
