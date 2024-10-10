package com.nttdata.proyecto3.AccountMs.business;

import com.nttdata.proyecto3.AccountMs.model.entity.Account;
import com.nttdata.proyecto3.AccountMs.repository.AccountRepository;
import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<AccountResponse> listAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::getAccountResponseOfAccount)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse getAccountById(String id) {
        return accountMapper.getAccountResponseOfAccount(
                accountRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Credit Card not found"))
        );
    }

    @Override
    public AccountResponse registerAccount(AccountRequest accountRequest) {
        return accountMapper.getAccountResponseOfAccount(accountRepository
                .save(accountMapper.getAccountOfAccountRequest(accountRequest)));
    }

    @Override
    public AccountResponse updateAccount(String id, AccountRequest accountRequest) {
        return accountRepository.findById(id)
                .map(existingCard -> {
                    Account updatedCard = accountMapper.getAccountOfAccountRequest(accountRequest);
                    updatedCard.setId(existingCard.getId());
                    return accountRepository.save(updatedCard);
                })
                .map(accountMapper::getAccountResponseOfAccount)
                .orElseThrow(() -> new NoSuchElementException("Credit Card not found"));
    }

    @Override
    public void deleteAccountById(String id) {
        accountRepository.findById(id)
                .ifPresentOrElse(accountRepository::delete,
                        () -> { throw new NoSuchElementException("Credit Card not found"); });
    }
}
