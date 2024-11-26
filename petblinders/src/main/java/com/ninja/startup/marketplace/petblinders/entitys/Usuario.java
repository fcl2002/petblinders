package com.ninja.startup.marketplace.petblinders.entitys;

import lombok.Data;
import lombok.ToString;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@ToString(exclude = "senha")       // senha não pode ser exibida no console log
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

    private boolean vendedor;

    @DBRef
    @Field("pedidos")
    private List<Pedido> pedidos;
}
