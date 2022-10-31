package oop.inheritance.application.printer;

import oop.library.v240m.VerifoneV240mPrinter;

public class PrinterVerifone implements IPrinter {
    VerifoneV240mPrinter verifoneV240mPrinter;
    private static PrinterVerifone unique;

    public PrinterVerifone(){
        verifoneV240mPrinter = new VerifoneV240mPrinter();
    }

    @Override
    public void print(int x, String message) {
        verifoneV240mPrinter.print(x,message);
    }

    @Override
    public void linefeed() {
        verifoneV240mPrinter.lineFeed();
    }

    public static PrinterVerifone getInstance(){
        if (unique==null){
            synchronized (PrinterVerifone.class){
                if (unique == null){
                    unique = new PrinterVerifone();
                }
            }
        }
        return getInstance();
    }
}
