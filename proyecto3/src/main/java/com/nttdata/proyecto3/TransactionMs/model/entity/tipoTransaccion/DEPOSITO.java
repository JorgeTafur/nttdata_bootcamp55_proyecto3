package com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion;

import com.nttdata.proyecto3.AccountMs.model.entity.Account;

public class DEPOSITO implements Tipo {

    @Override
    public void validarRetiro(double monto, Account cuenta) {
        cuenta.getTipoCuenta().validarRetiro(cuenta.getSaldo(), monto);
    }
}
