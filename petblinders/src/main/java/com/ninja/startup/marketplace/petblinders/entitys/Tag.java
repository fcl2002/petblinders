package com.ninja.startup.marketplace.petblinders.entitys;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

@Data
@EntityScan
public class Tag {
    private Long id;
    private String nome;
}
