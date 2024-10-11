package com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta;

public class CORRIENTE implements TipoCuenta {

    private static final double SOBREGIRO_MAXIMO = -500.0;

    @Override
    public void validarRetiro(double saldoActual, double monto) {
        if (saldoActual - monto < SOBREGIRO_MAXIMO) {
            throw new IllegalStateException("Las cuentas corrientes pueden tener un sobregiro de hasta -500.");
        }
    }

    @Override
    public void validarDeposito(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor a 0.");
        }
    }
}