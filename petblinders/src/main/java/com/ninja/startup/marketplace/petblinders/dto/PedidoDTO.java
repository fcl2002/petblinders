package com.ninja.startup.marketplace.petblinders.dto;

import java.time.LocalDateTime;

import com.ninja.startup.marketplace.petblinders.entity.Pedido;
import com.ninja.startup.marketplace.petblinders.entity.StatusPedido;

public class PedidoDTO {
	 private StatusPedido status;
	 private double frete;
	 private double valorTotal;
	 private UsuarioDTO usuario;
	 private LocalDateTime dataCriacao;
	 private LocalDateTime dataAtualizacao;
	    
	 public PedidoDTO() {}
	 
	 public PedidoDTO(Pedido pedido) {
		 this.status = pedido.getStatus();
		 this.frete = pedido.getFrete();
		 this.dataAtualizacao = pedido.getDataAtualizacao();
		 this.dataCriacao = pedido.getDataCriacao();
		 this.usuario = new UsuarioDTO(pedido.getUsuario());
	 }

	public StatusPedido getStatus() {
		return status;
	}

	public double getFrete() {
		return frete;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	 
	 
}
