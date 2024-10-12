package com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta;

public class AHORROS implements TipoCuenta {

    @Override
    public void validarRetiro(double saldoActual, double monto) {
        if (saldoActual < monto) {
            throw new IllegalStateException("No se puede realizar un retiro que deje el saldo en negativo.");
        }
    }

    @Override
    public void validarDeposito(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor a 0.");
        }
    }
}
