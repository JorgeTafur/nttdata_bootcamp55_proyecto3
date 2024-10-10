package com.nttdata.proyecto3.creditcards;


import com.nttdata.proyecto3.api.CardsApiDelegate;
import com.nttdata.proyecto3.creditcards.business.CreditCardService;
import com.nttdata.proyecto3.model.CreditCardRequest;
import com.nttdata.proyecto3.model.CreditCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardDelegateImpl implements CardsApiDelegate {

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
