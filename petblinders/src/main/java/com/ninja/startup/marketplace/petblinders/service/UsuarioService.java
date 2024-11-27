package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.entity.Carrinho;
import com.ninja.startup.marketplace.petblinders.entity.Usuario;
import com.ninja.startup.marketplace.petblinders.repository.CarrinhoRepository;
import com.ninja.startup.marketplace.petblinders.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final CarrinhoRepository carrinhoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, CarrinhoRepository carrinhoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
            throw new IllegalArgumentException("Email já registrado - " + usuario.getEmail());
        
        Usuario newUser = usuarioRepository.save(usuario);
        
        Carrinho c = new Carrinho();
        c.setItens(List.of());
        c.setValorTotal(0.0);
        Carrinho carrinhoSalvo = carrinhoRepository.save(c);

        newUser.setCarrinho(carrinhoSalvo);

        return usuarioRepository.save(newUser);
    }

    public Usuario atualizarUsuario(String id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = getUserById(id);
    
            if (usuarioAtualizado.getNome() != null) {
                usuario.setNome(usuarioAtualizado.getNome());
            }
            if (usuarioAtualizado.getEmail() != null) {
                // verificação de atributo único
                Optional<Usuario> emailExistente = usuarioRepository.findByEmail(usuarioAtualizado.getEmail());
                
                if (emailExistente.isPresent() && !emailExistente.get().getId().equals(id))
                    throw new IllegalArgumentException("Email já registrado - " + usuarioAtualizado.getEmail());
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
        } else
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
    }

    public void deletarUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));

        if (usuario.getCarrinho() != null)
            carrinhoRepository.deleteById(usuario.getCarrinho().getId());

        usuarioRepository.deleteById(id);
    }
}
