package com.ninja.startup.marketplace.entitys;

import java.util.List;

import lombok.Data;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@Data
@EntityScan
public class Item {
    private Long id;
    private String nome;
    private double valor;
    private int quantidade;
    private String descricao;

    private List<Tag> tags;
}
