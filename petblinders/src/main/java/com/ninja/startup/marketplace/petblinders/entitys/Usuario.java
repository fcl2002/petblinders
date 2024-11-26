package com.ninja.startup.marketplace.petblinders.entitys;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;

    @Field("nome_completo")
    private String nome;
    
    @Field("email")
    @Indexed(unique = true)
    private String email;

    private String senha;

    @Indexed(unique = true)
    private String telefone;

    private Boolean vendedor;

    @DBRef
    @Field("pedidos")
    private List<Pedido> pedidos;

    public Usuario(String id, String nome, String email, String senha, String telefone, Boolean vendedor, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.vendedor = vendedor;
        this.pedidos = pedidos;
    }

    // Getters and Setters
    public String getId() {
        return id;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Boolean getVendedor() {
        return vendedor;
    }
    
    public void setVendedor(Boolean vendedor) {
        this.vendedor = vendedor;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
