package com.ninja.startup.marketplace.petblinders.dto;

import java.util.ArrayList;
import java.util.List;

import com.ninja.startup.marketplace.petblinders.entity.Item;

public class ItemDto {
	private String nome;
    private double valor;
    private int quantidade;
    private String descricao;
    
    List<String> idTags = new ArrayList<>();
    
    public ItemDto() {}
    
    public ItemDto(Item item) {
    	this.nome = item.getNome();
    	this.descricao = item.getDescricao();
    	this.valor = item.getValor();
    	this.quantidade = item.getQuantidade();
    	item.getTags().forEach(tag -> this.idTags.add(tag.getId()));
    }

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<String> getIdTags() {
		return idTags;
	}
    
    
}