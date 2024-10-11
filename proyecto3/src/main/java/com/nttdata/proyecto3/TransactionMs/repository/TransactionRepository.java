package com.nttdata.proyecto3.TransactionMs.repository;

import com.nttdata.proyecto3.TransactionMs.model.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction,String> {
}
