package com.nttdata.creditcards.business;


import com.nttdata.creditcards.model.CreditCardRequest;
import com.nttdata.creditcards.model.CreditCardResponse;

import java.util.List;


public interface CreditCardService {

    List<CreditCardResponse> listCreditCards();
    CreditCardResponse getCreditCardById(String id);
    CreditCardResponse registerCreditCard(CreditCardRequest creditCardRequest);
    CreditCardResponse updateCreditCard(String id, CreditCardRequest creditCardRequest);
    void deleteCreditCardById(String id);
}
