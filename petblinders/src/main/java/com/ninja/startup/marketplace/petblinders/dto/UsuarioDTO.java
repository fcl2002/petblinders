package com.ninja.startup.marketplace.petblinders.dto;

import java.util.ArrayList;
import java.util.List;

import com.ninja.startup.marketplace.petblinders.entity.Usuario;

public class UsuarioDTO {
	private String id;
	
    private String nome;

    private String email;

    private String telefone;

    private boolean vendedor;

    private CarrinhoDTO carrinho;
 
    private List<String> pedidosId = new ArrayList<>();
    
    public UsuarioDTO() {}
    
    public UsuarioDTO(Usuario usuario) {
    	this.id = usuario.getId();
    	this.carrinho = new CarrinhoDTO(usuario.getCarrinho());
    	this.email = usuario.getEmail();
    	this.nome = usuario.getNome();
    	this.telefone = usuario.getTelefone();
    	usuario.getPedidos().forEach(pedido -> this.pedidosId.add(pedido.getId()));
    }

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public boolean isVendedor() {
		return vendedor;
	}

	public CarrinhoDTO getCarrinho() {
		return carrinho;
	}

	public List<String> getPedidosId() {
		return pedidosId;
	}

	public String getId() {
		return id;
	}
    
    
}
