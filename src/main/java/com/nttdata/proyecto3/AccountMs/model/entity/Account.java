package com.nttdata.proyecto3.AccountMs.model.entity;

import com.nttdata.proyecto3.AccountMs.model.entity.tipoCuenta.TipoCuenta;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numeroCuenta;

    private double saldo;
    private TipoCuenta tipoCuenta;
    private String clienteId;
}
