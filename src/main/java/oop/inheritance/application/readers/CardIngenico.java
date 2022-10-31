package oop.inheritance.application.readers;

import oop.inheritance.application.model.EntryMode;
import oop.inheritance.application.model.ExpirationDateIngenico;
import oop.inheritance.application.model.ICard;
import oop.inheritance.application.model.IExpirationDate;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.CardBuilder;
import oop.library.ingenico.model.ExpirationDate;

public class CardIngenico implements ICard {

    private Card card;

    public CardIngenico(int year, int month, String account,String mode){

        card = Card.builder().
                account(account).
                entryMode(oop.library.ingenico.model.EntryMode.valueOf(mode)).
                expirationDate(ExpirationDate.builder().
                        month(month).year(year).
                        build()).build();

    }

    @Override
    public String getAccount() {
        return card.getAccount();
    }

    @Override
    public IExpirationDate getExpirationDate() {
        return new ExpirationDateIngenico(card.getExpirationDate().getYear(),card.getExpirationDate().getMonth());
    }

    @Override
    public EntryMode getEntryMode() {
        return  EntryMode.valueOf(card.getEntryMode().name());
    }
}
