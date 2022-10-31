package oop.inheritance.application.readers;

import oop.inheritance.application.model.ICard;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.services.IngenicoChipReader;

public class ChipReaderIngenico implements ICardReader{
    private IngenicoChipReader chipReader;
    private Card card;
    private CardIngenico cardIngenico;
    private static ChipReaderIngenico unique;
    @Override
    public ICard readCard() {
        card = chipReader.readCard();
        cardIngenico = new CardIngenico(card.getExpirationDate().getYear(), card.getExpirationDate().getMonth(), card.getAccount(), card.getEntryMode().name());
        return cardIngenico;
    }

    public static ICardReader getInstance(){
        if (unique==null){
            synchronized (ChipReaderIngenico.class){
                if (unique==null){
                    unique = new ChipReaderIngenico();
                }
            }
        }
        return unique;
    }


}
