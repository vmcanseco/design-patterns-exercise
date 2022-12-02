package oop.inheritance.application.readers;

import java.util.Arrays;
import java.util.List;

public class CardProviderIngenico implements ICardProvider {

    public void readCard(ICardConsumer cardConsumer) {
        List<ICardReader> readers= Arrays.asList(ChipReaderIngenico.getInstance(),SwipperReaderIngenico.getInstance());

            readers.forEach(reader->{
                cardConsumer.consumeCard(reader.readCard(),"");
            });


    }
}
