package com.ninja.startup.marketplace.petblinders.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ninja.startup.marketplace.petblinders.entity.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    Optional<Usuario> findByEmail(String email);
}
