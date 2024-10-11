package com.nttdata.proyecto3.AccountMs.business;

import com.nttdata.proyecto3.AccountMs.repository.AccountRepository;
import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<AccountResponse> listAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::getAccountResponseOfAccount)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse getAccountById(String id) {
        return accountMapper.getAccountResponseOfAccount(
                accountRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada"))
        );
    }

    @Override
    public AccountResponse registerAccount(AccountRequest accountRequest) {

        Optional.of(accountRequest)
                .filter(request -> request.getSaldo() > 0)
                .orElseThrow(() -> new IllegalArgumentException("El saldo inicial debe ser mayor a 0"));

        accountRequest.setNumeroCuenta(generarNumeroCuenta());

        return accountMapper.getAccountResponseOfAccount(accountRepository
                .save(accountMapper.getAccountOfAccountRequest(accountRequest)));
    }

    private String generarNumeroCuenta() {
        // Generar un numero random de 10 dígitos
        return IntStream.range(0, 10)
                .map(i -> new Random().nextInt(10))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    @Override
    public AccountResponse depositAccount(String numeroCuenta, Amount amount) {
        return accountRepository.findAll().stream()
                .filter(account -> numeroCuenta.equals(account.getNumeroCuenta()))
                .findFirst()
                .map(account -> {
                    account.getTipoCuenta().validarDeposito(amount.getMonto()); // Validar depósito
                    double newBalance = account.getSaldo() + amount.getMonto();
                    account.setSaldo(newBalance);
                    return accountMapper.getAccountResponseOfAccount(accountRepository.save(account));
                })
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada para el número: " + numeroCuenta));
    }

    @Override
    public AccountResponse withdrawAccount(String numeroCuenta, Amount amount) {
        return accountRepository.findAll().stream()
                .filter(account -> numeroCuenta.equals(account.getNumeroCuenta()))
                .findFirst()
                .map(account -> {
                    account.getTipoCuenta().validarRetiro(account.getSaldo(), amount.getMonto());
                    double newBalance = account.getSaldo() - amount.getMonto();
                    account.setSaldo(newBalance);
                    return accountMapper.getAccountResponseOfAccount(accountRepository.save(account));
                })
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada para el número de cuenta: " + numeroCuenta));
    }

    @Override
    public void deleteAccountById(String id) {
        accountRepository.findById(id)
                .ifPresentOrElse(accountRepository::delete,
                        () -> { throw new NoSuchElementException("Cuenta no encontrada"); });
    }
}
