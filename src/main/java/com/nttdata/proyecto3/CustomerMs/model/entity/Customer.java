package com.nttdata.proyecto3.CustomerMs.model.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
}
