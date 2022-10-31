package oop.inheritance.application.transaction;

import oop.inheritance.application.model.ICard;
import oop.inheritance.application.readers.CardIngenico;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.EntryMode;
import oop.library.ingenico.model.ExpirationDate;
import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public class IngenicoTransaction   implements ITransaction {
    private Transaction transaction;

    public IngenicoTransaction(){
        transaction = new Transaction();
    }

    @Override
    public int getAmountInCents() {
        return transaction.getAmountInCents();
    }

    @Override
    public void setAmountInCents(int amountInCents) {
        transaction.setAmountInCents(amountInCents);
    }

    @Override
    public ICard getCard() {
        return new CardIngenico(transaction.getCard().getExpirationDate().getYear(),
                transaction.getCard().getExpirationDate().getMonth(),
                transaction.getCard().getAccount(),
                transaction.getCard().getEntryMode().name());
    }

    @Override
    public void setCard(ICard card) {
        transaction.setCard(Card.builder()
                .account(card.getAccount())
                .expirationDate(ExpirationDate.builder().year(card.getExpirationDate().getYear()).month(card.getExpirationDate().getMonth()).build())
                .entryMode(EntryMode.valueOf(card.getEntryMode().name()))
                .build());
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return transaction.getLocalDateTime();
    }

    @Override
    public void setLocalDateTime(LocalDateTime localDateTime) {
        transaction.setLocalDateTime(localDateTime);
    }
}
