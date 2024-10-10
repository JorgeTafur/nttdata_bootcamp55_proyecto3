package com.nttdata.creditcards;


import com.nttdata.creditcards.api.CardsApiDelegate;
import com.nttdata.creditcards.business.CreditCardService;
import com.nttdata.creditcards.model.CreditCardRequest;
import com.nttdata.creditcards.model.CreditCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardDelegateImp implements CardsApiDelegate {

    @Autowired
    CreditCardService creditCardService;

    @Override
    public ResponseEntity<List<CreditCardResponse>> listCreditCards() {
        return ResponseEntity.ok(creditCardService.listCreditCards());
    }

    @Override
    public ResponseEntity<CreditCardResponse> getCreditCardById(String id) {
        return ResponseEntity.ok(creditCardService.getCreditCardById(id));
    }

    @Override
    public ResponseEntity<CreditCardResponse> registerCreditCard(CreditCardRequest creditCardRequest) {
        return ResponseEntity.ok(creditCardService.registerCreditCard(creditCardRequest));
    }

    @Override
    public ResponseEntity<CreditCardResponse> updateCreditCard(String id, CreditCardRequest creditCardRequest) {
        return ResponseEntity.ok(creditCardService.updateCreditCard(id, creditCardRequest));
    }

    @Override
    public ResponseEntity<Void> deleteCreditCardById(String id) {
        creditCardService.deleteCreditCardById(id);
        return ResponseEntity.noContent().build();
    }

}
