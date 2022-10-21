package oop.inheritance.application;

import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;

import java.time.LocalDateTime;

public class IngenicoTransaction extends Transaction implements ITransaction {
    public IngenicoTransaction() {
        super();
    }

    @Override
    public int getAmountInCents() {
        return super.getAmountInCents();
    }

    @Override
    public void setAmountInCents(int amountInCents) {
        super.setAmountInCents(amountInCents);
    }

    @Override
    public Card getCard() {
        return super.getCard();
    }

    @Override
    public void setCard(Card card) {
        super.setCard(card);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return super.getLocalDateTime();
    }

    @Override
    public void setLocalDateTime(LocalDateTime localDateTime) {
        super.setLocalDateTime(localDateTime);
    }
}
