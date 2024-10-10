package com.nttdata.proyecto3.creditcards.business;


import com.nttdata.proyecto3.model.CreditCardRequest;
import com.nttdata.proyecto3.model.CreditCardResponse;

import java.util.List;


public interface CreditCardService {

    List<CreditCardResponse> listCreditCards();
    CreditCardResponse getCreditCardById(String id);
    CreditCardResponse registerCreditCard(CreditCardRequest creditCardRequest);
    CreditCardResponse updateCreditCard(String id, CreditCardRequest creditCardRequest);
    void deleteCreditCardById(String id);
}
