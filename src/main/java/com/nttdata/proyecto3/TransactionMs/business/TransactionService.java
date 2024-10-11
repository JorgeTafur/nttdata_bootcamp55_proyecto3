package com.nttdata.proyecto3.TransactionMs.business;


import com.nttdata.proyecto3.model.TransactionRequest;
import com.nttdata.proyecto3.model.TransactionResponse;
import com.nttdata.proyecto3.model.Amount;

import java.util.List;


public interface TransactionService {

    List<TransactionResponse> listTransactions();
    TransactionResponse registerTransactionDeposito(TransactionRequest transactionRequest);
    TransactionResponse registerTransactionRetiro(TransactionRequest transactionRequest);
    TransactionResponse registerTransactionTransferencia(TransactionRequest transactionRequest);
}
