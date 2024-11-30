package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.entity.Carrinho;
import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.repository.CarrinhoRepository;
import com.ninja.startup.marketplace.petblinders.repository.ItemRepository;

@Service
public class CarrinhoService {
    
    @Autowired
    private final CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private final ItemRepository itemRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ItemRepository itemRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.itemRepository = itemRepository;
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
        c.calcularTotal(carrinhoAtualizado.getItens());
        
        return carrinhoRepository.save(c);
    }

    public void deletarCarrinho(String id) {
        if(carrinhoRepository.existsById(id))
            carrinhoRepository.deleteById(id);
        else
            throw new RuntimeException("Carrinho não encontrado com o ID: " + id);
    }

    public Carrinho adicionarItem(String idCarrinho, Item novoItem) {

        Item itemOriginal = itemRepository.findById(novoItem.getId())
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado com o ID: " + novoItem.getId()));

        if (itemOriginal.getQuantidade() < novoItem.getQuantidade()) {
            throw new IllegalArgumentException("Quantidade solicitada maior que a disponível em estoque");
        }

        itemOriginal.setQuantidade(itemOriginal.getQuantidade() - novoItem.getQuantidade());
        itemRepository.save(itemOriginal);

        Carrinho carrinho = getCarrinhoById(idCarrinho);
        
        List<Item> itens = carrinho.getItens();
        boolean itemExistente = false;

        for(Item item : itens) {
            if (item.getId().equals(novoItem.getId())) {
                item.setQuantidade(item.getQuantidade() + novoItem.getQuantidade());
                itemExistente = true;
                break;                
            }
        }

        if(!itemExistente) {
            novoItem.setQuantidade(novoItem.getQuantidade());
            itens.add(novoItem);
        }

        carrinho.setItens(itens);
        carrinho.calcularTotal(itens);
        
        return carrinhoRepository.save(carrinho);
    }
}
