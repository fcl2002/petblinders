package com.ninja.startup.marketplace.petblinders.dto;

import java.util.ArrayList;
import java.util.List;

import com.ninja.startup.marketplace.petblinders.entity.Carrinho;

public class CarrinhoDTO {
	private String id;
    private double valorTotal;
    private List<ItemDTO> itens = new ArrayList<>()	;
    
    public CarrinhoDTO() {}
    
    public CarrinhoDTO(Carrinho carrinho) {
    	this.id = carrinho.getId();
    	this.valorTotal = carrinho.getValorTotal();
    	carrinho.getItens().forEach(item -> this.itens.add(new ItemDTO(item)));
    }

	public String getId() {
		return id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}
}
