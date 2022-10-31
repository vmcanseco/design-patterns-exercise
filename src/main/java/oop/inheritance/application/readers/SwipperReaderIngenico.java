package oop.inheritance.application.readers;

import oop.inheritance.application.model.ICard;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.services.IngenicoCardSwipper;

public class SwipperReaderIngenico implements ICardReader {
    private IngenicoCardSwipper cardSwipper;
    private Card card;
    private CardIngenico cardIngenico;

    private static SwipperReaderIngenico unique;

    public SwipperReaderIngenico(){
        cardSwipper = new IngenicoCardSwipper();

    }
    @Override
    public ICard readCard() {
        card = cardSwipper.readCard();
        cardIngenico = new CardIngenico(card.getExpirationDate().getYear(),
                card.getExpirationDate().getMonth(),
                card.getAccount(),
                card.getEntryMode().name());

        return cardIngenico;
    }

    public  static SwipperReaderIngenico getInstance(){
        if (unique == null) {
            synchronized(SwipperReaderIngenico.class){
                if (unique == null) {
                    unique = new SwipperReaderIngenico();
                }
            }
        }
        return unique;
    }
}
