package com.ninja.startup.marketplace.petblinders.dto;

import java.util.ArrayList;
import java.util.List;

import com.ninja.startup.marketplace.petblinders.entity.Tag;

public class TagDTO {
	private String nome;
	private String id;
	private List<String> itensId = new ArrayList<>();
	
	public TagDTO() {}
	
	public TagDTO(Tag tag) {
		this.nome = tag.getNome();
		this.id = tag.getId();
		
		if(tag.getItens() != null)
			tag.setItens(new ArrayList<>());
		else
			tag.getItens().forEach(item -> this.itensId.add(item.getId()));
	}

	public String getNome() {
		return nome;
	}

	public List<String> getItensId() {
		return itensId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setItensId(List<String> itensId) {
		this.itensId = itensId;
	}
	
	
	
	
}
