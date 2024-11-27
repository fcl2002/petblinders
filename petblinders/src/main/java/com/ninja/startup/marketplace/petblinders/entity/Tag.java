package com.ninja.startup.marketplace.petblinders.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tags")
public class Tag {
	@Id
    private String id;

    private String nome;

    @DBRef
    List<Item> itens;

    public Tag(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
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
}

