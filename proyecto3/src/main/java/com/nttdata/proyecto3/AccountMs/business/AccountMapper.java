package com.nttdata.proyecto3.AccountMs.business;

import com.nttdata.proyecto3.AccountMs.model.entity.Account;
import com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta.AHORROS;
import com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta.CORRIENTE;
import com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta.TipoCuenta;
import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account getAccountOfAccountRequest(AccountRequest request){
        Account entity = new Account();
        entity.setNumeroCuenta(request.getNumeroCuenta());
        entity.setSaldo(request.getSaldo());
        entity.setTipoCuenta(getTipoCuenta(request.getTipoCuenta()));
        entity.setId(request.getId());
        entity.setClienteId(request.getClienteId());
        return entity;

    }

    public AccountResponse getAccountResponseOfAccount(Account entity){
        AccountResponse response = new AccountResponse();
        response.setNumeroCuenta(entity.getNumeroCuenta());
        response.setSaldo(entity.getSaldo());
        response.setTipoCuenta(entity.getTipoCuenta().getClass().getSimpleName());
        response.setId(entity.getId());
        response.setClienteId(entity.getClienteId());
        return response;

    }

    private TipoCuenta getTipoCuenta(String tipoCuenta) {
        if ("AHORROS".equalsIgnoreCase(tipoCuenta)) {
            return new AHORROS();
        } else if ("CORRIENTE".equalsIgnoreCase(tipoCuenta)) {
            return new CORRIENTE();
        } else {
            throw new IllegalArgumentException("Tipo de cuenta no válido: " + tipoCuenta);
        }
    }
}
