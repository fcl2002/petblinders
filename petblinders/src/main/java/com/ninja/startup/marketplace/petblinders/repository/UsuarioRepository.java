package com.ninja.startup.marketplace.petblinders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ninja.startup.marketplace.petblinders.entitys.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
