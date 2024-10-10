package com.nttdata.proyecto3.creditcards.repository;

import com.nttdata.proyecto3.creditcards.model.entity.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardRepository extends MongoRepository<CreditCard,String> {
}
