package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.entity.Carrinho;
import com.ninja.startup.marketplace.petblinders.repository.CarrinhoRepository;

@Service
public class CarrinhoService {
    
    @Autowired
    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho getCarrinhoById(String id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado com o ID: " + id));
    }

    public Carrinho criarCarrinho(Carrinho c) {
        return carrinhoRepository.save(c);
    }

    public Carrinho atualizarCarrinho(String id, Carrinho carrinhoAtualizado) {
        Carrinho c = getCarrinhoById(id);
        c.setItens(carrinhoAtualizado.getItens());
        return carrinhoRepository.save(c);
    }

    public void deletarCarrinho(String id) {
        if(carrinhoRepository.existsById(id))
            carrinhoRepository.deleteById(id);
        else
            throw new RuntimeException("Carrinho não encontrado com o ID: " + id);
    }
}
