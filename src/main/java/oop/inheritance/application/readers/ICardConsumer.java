package oop.inheritance.application.readers;

import oop.inheritance.application.model.ICard;

@FunctionalInterface
public interface ICardConsumer {

    void consumeCard(ICard card, String value);

}
