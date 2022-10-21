package oop.inheritance.application.printer;

import oop.library.ingenico.services.IngenicoPrinter;

public class PrinterIngenico extends IngenicoPrinter implements IPrinter {
    @Override
    public void fprint(int x, String message) {
         super.print(x,message);
    }

    @Override
    public void flinefeed() {
        super.lineFeed();
    }
}
