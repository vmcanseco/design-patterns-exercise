package oop.inheritance.application.model;

import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.CardBuilder;

public class CardIngenico implements ICard {

    private Card card;
    private  ExpirationDateIngenico expirationDate;

    public CardIngenico(int year, int month, String account){

        expirationDate=new ExpirationDateIngenico(year,month);

    }

    @Override
    public String getAccount() {
        return null;
    }

    @Override
    public IExpirationDate getExpirationDate() {
        return expirationDate;
    }
}
