package com.nttdata.proyecto3.AccountMs.repository;

import com.nttdata.proyecto3.AccountMs.model.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,String> {
}
