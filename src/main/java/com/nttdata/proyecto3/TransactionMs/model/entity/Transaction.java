package com.nttdata.proyecto3.TransactionMs.model.entity;

import com.nttdata.proyecto3.TransactionMs.model.entity.tipoTransaccion.Tipo;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    private double monto;
    private LocalDate fecha;

    private String cuentaOrigen;
    private String cuentaDestino;

    private Tipo tipo;
}
