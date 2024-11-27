package com.ninja.startup.marketplace.petblinders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ninja.startup.marketplace.petblinders.entity.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
