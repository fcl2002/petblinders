package com.ninja.startup.marketplace.petblinders.entitys;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@EntityScan
public class Tag {
	@Id
    private String id;
    private String nome;
}
