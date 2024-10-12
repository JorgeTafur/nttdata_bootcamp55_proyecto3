package com.nttdata.proyecto3.TransactionMs;

import com.nttdata.proyecto3.TransactionMs.business.TransactionService;
import com.nttdata.proyecto3.api.TransaccionesApiDelegate;
import com.nttdata.proyecto3.model.TransactionRequest;
import com.nttdata.proyecto3.model.TransactionResponse;
import com.nttdata.proyecto3.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDelegateImpl implements TransaccionesApiDelegate {

    @Autowired
    TransactionService transactionService;

    @Override
    public ResponseEntity<List<TransactionResponse>> listTransactions() {
        return ResponseEntity.ok(transactionService.listTransactions());
    }

    @Override
    public ResponseEntity<TransactionResponse> registerTransactionRetiro(TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.registerTransactionRetiro(transactionRequest));
    }

    @Override
    public ResponseEntity<TransactionResponse> registerTransactionDeposito(TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.registerTransactionDeposito(transactionRequest));
    }

    @Override
    public ResponseEntity<TransactionResponse> registerTransactionTransferencia(TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.registerTransactionTransferencia(transactionRequest));
    }

}
