package com.ninja.startup.marketplace.entitys;

import lombok.Data;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
public class Carrinho {
    private Long id;
    private double valorTotal;

    private List<Item> itens;

    public void calcularTotal() {
        // atualizar o valor da variável
    }
}
