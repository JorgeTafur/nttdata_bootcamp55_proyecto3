package com.nttdata.proyecto3.AccountMs.business;


import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.Amount;

import java.util.List;


public interface AccountService {

    List<AccountResponse> listAccounts();
    AccountResponse getAccountById(String id);
    AccountResponse registerAccount(AccountRequest accountRequest);
    AccountResponse depositAccount(String numeroCuenta, Amount amount);
    AccountResponse withdrawAccount(String numeroCuenta, Amount amount);
    void deleteAccountById(String id);
}
