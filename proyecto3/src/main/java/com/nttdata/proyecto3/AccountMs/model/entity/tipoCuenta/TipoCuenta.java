package com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta;

public interface TipoCuenta {
    void validarRetiro(double saldoActual, double monto);
    void validarDeposito(double monto);
}
