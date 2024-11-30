package com.ninja.startup.marketplace.petblinders.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

@Document(collection = "pedidos")
public class Pedido {

    @Id
    private String id;

    private StatusPedido status; // Enum para os status do pedido

    @Min(value = 0, message = "O frete não pode ser negativo")
    private double frete;

    @Min(value = 0, message = "O valor total não pode ser negativo")
    private double valorTotal;

    @DBRef
    private Usuario usuario;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    public Pedido(String id, StatusPedido status, double frete, double valorTotal, Usuario usuario, 
                  LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.status = status;
        this.frete = frete;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
