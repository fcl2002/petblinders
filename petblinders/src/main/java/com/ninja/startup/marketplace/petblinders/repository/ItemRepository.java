package com.ninja.startup.marketplace.petblinders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ninja.startup.marketplace.petblinders.entitys.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long>{
	
}
