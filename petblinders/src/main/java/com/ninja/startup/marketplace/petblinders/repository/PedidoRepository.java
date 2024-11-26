package com.ninja.startup.marketplace.petblinders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ninja.startup.marketplace.petblinders.entitys.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>{

}
