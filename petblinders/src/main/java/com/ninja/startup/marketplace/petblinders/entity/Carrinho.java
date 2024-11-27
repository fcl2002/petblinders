package com.ninja.startup.marketplace.petblinders.entity;

import lombok.Data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;

@Data
@Document(collection = "carrinhos")

public class Carrinho {
    @Id
    private String id;

    @Min(message = "O valor total do carrinho não pode ser negativo", value = 0)
    private double valorTotal;

    @DBRef
    private List<Item> itens;

    public void calcularTotal() {
        // atualizar o valor da variável
    }
}
