package com.nttdata.proyecto3.AccountMs.model.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;
    private String numeroCuenta;
    private double saldo;
    private String tipoCuenta;
    private String clienteId;
}
