package com.nttdata.creditcards.repository;

import com.nttdata.creditcards.model.entity.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardRepository extends MongoRepository<CreditCard,String> {
}
