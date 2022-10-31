package oop.inheritance.application;

import oop.inheritance.application.display.IDisplay;
import oop.inheritance.application.factory.IPeripheralFactory;
import oop.inheritance.application.keyboard.IKeyboard;

public class ApplicationVerifoneImpl implements IApplication{
    IDisplay verifoneDisplay;
    IKeyboard verifoneKeyboard;
    public ApplicationVerifoneImpl(IPeripheralFactory peripheralFactory){
        verifoneDisplay = peripheralFactory.createDisplay();
        verifoneKeyboard = peripheralFactory.createKeyboard();

    }
    @Override
    public void clearScreen() {
        verifoneDisplay.clear();
    }

    @Override
    public void showMenu() {
        verifoneDisplay.showMessage(5, 5, "MENU");
        verifoneDisplay.showMessage(5, 10, "1. VENTA");
        verifoneDisplay.showMessage(5, 13, "2. DEVOLUCION");
        verifoneDisplay.showMessage(5, 16, "3. REPORTE");
        verifoneDisplay.showMessage(5, 23, "4. CONFIGURACION");
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
        return verifoneKeyboard.getChar();
    }
}
