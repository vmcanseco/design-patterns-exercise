package oop.inheritance.application.printer;

import oop.library.ingenico.services.IngenicoPrinter;

public class PrinterIngenico  implements IPrinter {

    private IngenicoPrinter ingenicoPrinter;
    private static PrinterIngenico unique;
    public PrinterIngenico(){
        ingenicoPrinter=new IngenicoPrinter();
    }
    @Override
    public void print(int x, String message) {
        ingenicoPrinter.print(x,message);
    }

    @Override
    public void lineFeed() {
        ingenicoPrinter.lineFeed();
    }

    public static PrinterIngenico getInstance(){
        if (unique==null){
            synchronized (PrinterIngenico.class){
                if (unique == null){
                    unique = new PrinterIngenico();
                }
            }
        }
        return getInstance();
    }
}
