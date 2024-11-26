package com.ninja.startup.marketplace.petblinders.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Min;

@Document(collection = "itens")
public class Item {
	@Id
    private String id;
    @Field
    private String nome;
    
    @Field
    @Min(value = 0, message = "O valor não pode ser negativo")
    private double valor;
    
    @Field
    @Min(value = 0, message = "A quantidade não pode ser negativo")
    private int quantidade;
    
    private String descricao;

    @DBRef
    private Tag tag;

    public Item(String id, String nome, double valor, int quantidade, String descricao, Tag tag) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.tag = tag;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
