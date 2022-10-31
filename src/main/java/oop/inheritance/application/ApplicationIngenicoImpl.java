package oop.inheritance.application;

import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.factory.IPeripheralFactory;
import oop.inheritance.application.keyboard.IKeyboard;

public class ApplicationIngenicoImpl implements IApplication {

    private IDisplay ingenicoDisplay;
    private IKeyboard ingenicoKeyboard;

    public ApplicationIngenicoImpl(IPeripheralFactory peripheralFactory) {
        ingenicoDisplay = peripheralFactory.createDisplay();
        ingenicoKeyboard = peripheralFactory.createKeyboard();
    }

    @Override
    public void clearScreen() {

        ingenicoDisplay.clear();
    }

    @Override
    public void showMenu() {
        ingenicoDisplay.showMessage(5, 5, "MENU");
        ingenicoDisplay.showMessage(5, 10, "1. VENTA");
        ingenicoDisplay.showMessage(5, 13, "2. DEVOLUCION");
        ingenicoDisplay.showMessage(5, 16, "3. REPORTE");
        ingenicoDisplay.showMessage(5, 23, "4. CONFIGURACION");
    }

    @Override
    public void doSale() {

    }

    @Override
    public void doRefund() {

    }

    @Override
    public void printReport() {

    }

    @Override
    public void showConfiguration() {

    }

    @Override
    public String readKey() {
        return ingenicoKeyboard.getChar();
    }
}
