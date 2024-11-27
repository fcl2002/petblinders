package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.entity.Usuario;
import com.ninja.startup.marketplace.petblinders.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario createUser(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getEmail()).isPresent())
            throw new IllegalArgumentException("Email já registrado - " + usuario.getEmail());

        return usuarioRepository.save(usuario);
    }

    public Usuario updateUser(String id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = getUserById(id);
    
            if (usuarioAtualizado.getNome() != null) {
                usuario.setNome(usuarioAtualizado.getNome());
            }
            if (usuarioAtualizado.getEmail() != null) {
                usuario.setEmail(usuarioAtualizado.getEmail());
            }
            if (usuarioAtualizado.getTelefone() != null) {
                usuario.setTelefone(usuarioAtualizado.getTelefone());
            }
            if (usuarioAtualizado.getSenha() != null) {
                usuario.setSenha(usuarioAtualizado.getSenha());
            }
            if (usuarioAtualizado.getVendedor() != null) {
                usuario.setVendedor(usuarioAtualizado.getVendedor());
            }
    
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

    public void deleteUser(String id) {
        if (usuarioRepository.existsById(id))
            usuarioRepository.deleteById(id);
        else
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
    }
}
