package com.nttdata.creditcards.model.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "credit_cards")
public class CreditCard {
    @Id
    private String id;
    private String cardNumber;
    private String accountHolder;
    private BigDecimal balance;
    private BigDecimal creditLimit;
}
