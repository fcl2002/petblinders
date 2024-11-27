package com.ninja.startup.marketplace.petblinders.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;

@Document(collection = "carrinhos")
public class Carrinho {
    @Id
    private String id;

    @Min(message = "O valor total do carrinho não pode ser negativo", value = 0)
    private double valorTotal;

    @DBRef
    private List<Item> itens;

    public Carrinho() {
        
    }

    public Carrinho(String id, double valorTotal, List<Item> itens) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.itens = List.of();
    }

    public void calcularTotal() {
        this.valorTotal = itens.stream()
                            .mapToDouble(item -> item.getValor() * item.getQuantidade())
                            .sum();
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
