package com.ninja.startup.marketplace.petblinders.entitys;

import java.util.List;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "itens")

public class Item {
	@Id
    private String id;
    private String nome;
    private double valor;
    private int quantidade;
    private String descricao;

    private List<Tag> tags;
}
