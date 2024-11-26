package com.ninja.startup.marketplace.petblinders.repository;

import com.ninja.startup.marketplace.petblinders.entitys.Carrinho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends MongoRepository<Carrinho, String>{

}
