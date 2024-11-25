package com.ninja.startup.marketplace.entitys;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
    private List<Usuario> usuarios;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;
}
