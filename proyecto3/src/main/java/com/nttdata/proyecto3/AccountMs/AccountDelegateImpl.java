package com.nttdata.proyecto3.AccountMs;

import com.nttdata.proyecto3.AccountMs.business.AccountService;
import com.nttdata.proyecto3.api.CuentasApiDelegate;
import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDelegateImpl implements CuentasApiDelegate {

    @Autowired
    AccountService accountService;

    @Override
    public ResponseEntity<List<AccountResponse>> listAccounts() {
        return ResponseEntity.ok(accountService.listAccounts());
    }

    @Override
    public ResponseEntity<AccountResponse> getAccountById(String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @Override
    public ResponseEntity<AccountResponse> registerAccount(AccountRequest accountRequest) {
        return ResponseEntity.ok(accountService.registerAccount(accountRequest));
    }

    @Override
    public ResponseEntity<AccountResponse> depositAccount(String numeroCuenta, Amount amount) {
        return ResponseEntity.ok(accountService.depositAccount(numeroCuenta, amount));
    }

    @Override
    public ResponseEntity<AccountResponse> withdrawAccount(String numeroCuenta, Amount amount) {
        return ResponseEntity.ok(accountService.withdrawAccount(numeroCuenta, amount));
    }

    @Override
    public ResponseEntity<Void> deleteAccountById(String id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

}
