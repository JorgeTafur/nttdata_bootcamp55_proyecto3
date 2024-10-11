package com.nttdata.proyecto3.TransactionMs.business;

import com.nttdata.proyecto3.AccountMs.business.AccountService;
import com.nttdata.proyecto3.AccountMs.model.entity.Account;
import com.nttdata.proyecto3.AccountMs.repository.AccountRepository;
import com.nttdata.proyecto3.TransactionMs.business.TransactionMapper;
import com.nttdata.proyecto3.TransactionMs.business.TransactionService;
import com.nttdata.proyecto3.TransactionMs.repository.TransactionRepository;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.TransactionRequest;
import com.nttdata.proyecto3.model.TransactionResponse;
import com.nttdata.proyecto3.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Override
    public List<TransactionResponse> listTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::getTransactionResponseOfTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionResponse registerTransactionDeposito(TransactionRequest transactionRequest) {

        transactionRequest.setFecha(LocalDate.now());
        transactionRequest.setTipo("DEPOSITO");

        Account cuentaDestino = getAccountDestinyFromTransaction(transactionRequest);
        cuentaDestino.getTipoCuenta().validarDeposito(transactionRequest.getMonto());

        Amount monto = new Amount();
        monto.setMonto(transactionRequest.getMonto());

        accountService.depositAccount(transactionRequest.getCuentaDestino(),monto);

        return transactionMapper.getTransactionResponseOfTransaction(transactionRepository
                .save(transactionMapper.getTransactionOfTransactionRequest(transactionRequest)));
    }

    @Override
    public TransactionResponse registerTransactionRetiro(TransactionRequest transactionRequest) {

        transactionRequest.setFecha(LocalDate.now());
        transactionRequest.setTipo("RETIRO");

        Account cuentaOrigen = getAccountOriginFromTransaction(transactionRequest);

        cuentaOrigen.getTipoCuenta().validarRetiro(cuentaOrigen.getSaldo(), transactionRequest.getMonto());

        Amount monto = new Amount();
        monto.setMonto(transactionRequest.getMonto());

        accountService.withdrawAccount(transactionRequest.getCuentaOrigen(),monto);

        return transactionMapper.getTransactionResponseOfTransaction(transactionRepository
                .save(transactionMapper.getTransactionOfTransactionRequest(transactionRequest)));
    }

    @Override
    public TransactionResponse registerTransactionTransferencia(TransactionRequest transactionRequest) {

        transactionRequest.setFecha(LocalDate.now());
        transactionRequest.setTipo("TRANSFERENCIA");

        Account cuentaOrigen = getAccountOriginFromTransaction(transactionRequest);
        Account cuentaDestino = getAccountDestinyFromTransaction(transactionRequest);

        cuentaOrigen.getTipoCuenta().validarRetiro(cuentaOrigen.getSaldo(), transactionRequest.getMonto());
        cuentaDestino.getTipoCuenta().validarDeposito(transactionRequest.getMonto());

        Amount monto = new Amount();
        monto.setMonto(transactionRequest.getMonto());

        accountService.withdrawAccount(transactionRequest.getCuentaOrigen(),monto);
        accountService.depositAccount(transactionRequest.getCuentaDestino(),monto);

        return transactionMapper.getTransactionResponseOfTransaction(transactionRepository
                .save(transactionMapper.getTransactionOfTransactionRequest(transactionRequest)));

    }

    public Account getAccountOriginFromTransaction(TransactionRequest transactionRequest) {
        return accountRepository.findAll().stream()
                .filter(account -> transactionRequest.getCuentaOrigen().equals(account.getNumeroCuenta()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada para el número: " + transactionRequest.getCuentaOrigen()));
    }

    public Account getAccountDestinyFromTransaction(TransactionRequest transactionRequest) {
        return accountRepository.findAll().stream()
                .filter(account -> transactionRequest.getCuentaDestino().equals(account.getNumeroCuenta()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada para el número: " + transactionRequest.getCuentaDestino()));
    }

}
