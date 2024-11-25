package com.ninja.startup.marketplace.entitys;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean vendedor;

    private Pedido pedido;
}
