package com.nttdata.proyecto3.creditcards.business;

import com.nttdata.proyecto3.model.CreditCardRequest;
import com.nttdata.proyecto3.model.CreditCardResponse;
import com.nttdata.proyecto3.creditcards.model.entity.CreditCard;
import com.nttdata.proyecto3.creditcards.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    CreditCardMapper creditCardMapper;

    @Override
    public List<CreditCardResponse> listCreditCards() {
        return creditCardRepository.findAll().stream()
                .map(creditCardMapper::getCreditCardResponseOfCreditCard)
                .collect(Collectors.toList());
    }

    @Override
    public CreditCardResponse getCreditCardById(String id) {
        return creditCardMapper.getCreditCardResponseOfCreditCard(
                creditCardRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Credit Card not found"))
        );
    }

    @Override
    public CreditCardResponse registerCreditCard(CreditCardRequest creditCardRequest) {
        return creditCardMapper.getCreditCardResponseOfCreditCard(creditCardRepository
                .save(creditCardMapper.getCreditCardOfCreditCardRequest(creditCardRequest)));
    }

    @Override
    public CreditCardResponse updateCreditCard(String id, CreditCardRequest creditCardRequest) {
        return creditCardRepository.findById(id)
                .map(existingCard -> {
                    CreditCard updatedCard = creditCardMapper.getCreditCardOfCreditCardRequest(creditCardRequest);
                    updatedCard.setId(existingCard.getId());
                    return creditCardRepository.save(updatedCard);
                })
                .map(creditCardMapper::getCreditCardResponseOfCreditCard)
                .orElseThrow(() -> new NoSuchElementException("Credit Card not found"));
    }

    @Override
    public void deleteCreditCardById(String id) {
        creditCardRepository.findById(id)
                .ifPresentOrElse(creditCardRepository::delete,
                        () -> { throw new NoSuchElementException("Credit Card not found"); });
    }
}
