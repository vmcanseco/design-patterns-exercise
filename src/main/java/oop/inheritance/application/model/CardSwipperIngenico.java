package oop.inheritance.application.model;

import oop.library.ingenico.services.IngenicoCardSwipper;

public class CardSwipperIngenico implements  ICardReader {
    private IngenicoCardSwipper cardSwipper;


    public  CardSwipperIngenico(){
        cardSwipper = new IngenicoCardSwipper();
        cardSwipper.
    }
    @Override
    public ICard readCard() {
        return null;
    }
}
