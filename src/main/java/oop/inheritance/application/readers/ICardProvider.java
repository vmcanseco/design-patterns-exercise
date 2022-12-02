package oop.inheritance.application.readers;

import oop.inheritance.application.model.ICard;

public interface ICardProvider {

    void readCard(ICardConsumer cardConsumer);
}
