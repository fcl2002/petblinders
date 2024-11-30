package com.ninja.startup.marketplace.petblinders.dto;

import java.util.ArrayList;
import java.util.List;

import com.ninja.startup.marketplace.petblinders.entity.Item;

public class ItemDTO {
	private String id;
	private String nome;
	private double valor;
	private int quantidade;
	private String descricao;

	List<String> idTags = new ArrayList<>();
	List<String> nomeTags = new ArrayList<>();

	public ItemDTO() { }

	public ItemDTO(Item item) {
		this.id = item.getId();
		this.nome = item.getNome();
		this.descricao = item.getDescricao();
		this.valor = item.getValor();
		this.quantidade = item.getQuantidade();
		item.getTags().forEach(tag -> this.idTags.add(tag.getId()));
		item.getTags().forEach(tag -> this.nomeTags.add(tag.getNome()));
	}

	
	public String getId() {
		return id;
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

	public List<String> getNomesTags() {
		return nomeTags;
	}
}
