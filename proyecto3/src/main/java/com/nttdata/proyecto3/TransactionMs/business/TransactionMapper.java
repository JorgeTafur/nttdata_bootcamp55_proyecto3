package com.nttdata.proyecto3.TransactionMs.business;

import com.nttdata.proyecto3.TransactionMs.model.entity.Transaction;
import com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion.DEPOSITO;
import com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion.RETIRO;
import com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion.TRANSFERENCIA;
import com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion.Tipo;
import com.nttdata.proyecto3.model.TransactionRequest;
import com.nttdata.proyecto3.model.TransactionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction getTransactionOfTransactionRequest(TransactionRequest request){
        Transaction entity = new Transaction();
        entity.setCuentaDestino(request.getCuentaDestino());
        entity.setCuentaOrigen(request.getCuentaOrigen());
        entity.setTipo(getTipoTransaccion(request.getTipo()));
        entity.setId(request.getId());
        entity.setFecha(request.getFecha());
        entity.setMonto(request.getMonto());
        return entity;

    }

    public TransactionResponse getTransactionResponseOfTransaction(Transaction entity){
        TransactionResponse response = new TransactionResponse();
        response.setCuentaDestino(entity.getCuentaDestino());
        response.setCuentaOrigen(entity.getCuentaOrigen());
        response.setTipo(entity.getTipo().getClass().getSimpleName());
        response.setId(entity.getId());
        response.setFecha(entity.getFecha());
        response.setMonto(entity.getMonto());
        return response;

    }

    private Tipo getTipoTransaccion(String tipoTransaccion) {
        if ("DEPOSITO".equalsIgnoreCase(tipoTransaccion)) {
            return new DEPOSITO();
        } else if ("RETIRO".equalsIgnoreCase(tipoTransaccion)) {
            return new RETIRO();
        } else if ("TRANSFERENCIA".equalsIgnoreCase(tipoTransaccion)) {
            return new TRANSFERENCIA();
        } else {
            throw new IllegalArgumentException("Tipo de transaccion no válida: " + tipoTransaccion);
        }
    }
}
