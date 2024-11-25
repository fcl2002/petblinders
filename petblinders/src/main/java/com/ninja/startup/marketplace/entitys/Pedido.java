package com.ninja.startup.marketplace.entitys;

import lombok.Data;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
public class Pedido {
    private Long id;
    private int status;        // 1 : Processando, 2 : Pago, 3: Enviado, 4 : Entregue
    private double frete;
    private double valorTotal;

    private List<Usuario> usuarios;
}
