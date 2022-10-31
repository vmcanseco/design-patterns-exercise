package oop.inheritance.application.model;

import oop.library.ingenico.model.ExpirationDate;

public class ExpirationDateIngenico implements IExpirationDate {
    private ExpirationDate expirationDate;

    public  ExpirationDateIngenico(int year, int month){
        expirationDate = new ExpirationDate(year,month);
    }

    @Override
    public int getYear() {
        return expirationDate.getYear();
    }

    @Override
    public int getMonth() {
        return  expirationDate.getMonth();
    }
}
