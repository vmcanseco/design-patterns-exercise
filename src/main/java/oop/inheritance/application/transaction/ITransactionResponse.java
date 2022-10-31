package oop.inheritance.application.transaction;

import oop.inheritance.application.model.ICard;
import oop.library.ingenico.model.Card;

import java.time.LocalDateTime;

public interface ITransactionResponse {
     boolean isApproved();

     void setApproved(boolean approved) ;

     String getHostReference();

     void setHostReference(String hostReference);
}
