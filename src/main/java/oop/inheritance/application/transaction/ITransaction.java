package oop.inheritance.application.transaction;

import oop.inheritance.application.model.ICard;

import java.time.LocalDateTime;

public interface ITransaction {

    int getAmountInCents();

    void setAmountInCents(int amountInCents);

    ICard getCard();

    void setCard(ICard card);

    LocalDateTime getLocalDateTime();

    void setLocalDateTime(LocalDateTime localDateTime);
}
