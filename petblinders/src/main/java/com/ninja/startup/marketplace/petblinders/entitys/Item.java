package com.ninja.startup.marketplace.petblinders.entitys;

import java.util.List;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "itens")

public class Item {
    private Long id;
    private String nome;
    private double valor;
    private int quantidade;
    private String descricao;

    private List<Tag> tags;
}
