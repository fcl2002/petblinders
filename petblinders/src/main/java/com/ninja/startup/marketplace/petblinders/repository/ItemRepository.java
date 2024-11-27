package com.ninja.startup.marketplace.petblinders.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ninja.startup.marketplace.petblinders.entity.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findByNome(String nome);
}
