package com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion;

import com.nttdata.proyecto3.AccountMs.model.entity.Account;

public interface Tipo {
    void validarRetiro(double monto, Account cuenta);
}