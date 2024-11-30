package com.ninja.startup.marketplace.petblinders.dto;

import java.util.ArrayList;
import java.util.List;

import com.ninja.startup.marketplace.petblinders.entity.Tag;

public class TagDTO {
	private String nome;
	private List<String> itensId = new ArrayList<>();
	
	public TagDTO() {}
	
	public TagDTO(Tag tag) {
		this.nome = tag.getNome();
		
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
	
	
}
