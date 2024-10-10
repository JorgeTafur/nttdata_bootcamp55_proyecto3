package com.nttdata.proyecto3.AccountMs.business;


import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;

import java.util.List;


public interface AccountService {

    List<AccountResponse> listAccounts();
    AccountResponse getAccountById(String id);
    AccountResponse registerAccount(AccountRequest accountRequest);
    AccountResponse updateAccount(String id, AccountRequest accountRequest);
    void deleteAccountById(String id);
}
