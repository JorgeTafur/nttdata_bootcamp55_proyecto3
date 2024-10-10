package com.nttdata.proyecto3.AccountMs.business;

import com.nttdata.proyecto3.AccountMs.model.entity.Account;
import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account getAccountOfAccountRequest(AccountRequest request){
        Account entity = new Account();
        entity.setNumeroCuenta(request.getNumeroCuenta());
        entity.setSaldo(request.getSaldo());
        entity.setTipoCuenta(request.getTipoCuenta());
        entity.setId(request.getId());
        entity.setClienteId(request.getClienteId());
        return entity;

    }

    public AccountResponse getAccountResponseOfAccount(Account entity){
        AccountResponse response = new AccountResponse();
        response.setNumeroCuenta(entity.getNumeroCuenta());
        response.setSaldo(entity.getSaldo());
        response.setTipoCuenta(entity.getTipoCuenta());
        response.setId(entity.getId());
        response.setClienteId(entity.getClienteId());
        return response;

    }
}
