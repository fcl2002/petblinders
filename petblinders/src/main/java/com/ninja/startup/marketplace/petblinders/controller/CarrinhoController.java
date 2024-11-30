package com.ninja.startup.marketplace.petblinders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.startup.marketplace.petblinders.dto.CarrinhoDTO;
import com.ninja.startup.marketplace.petblinders.entity.Carrinho;
import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.service.CarrinhoService;


@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    
    @Autowired
    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    public ResponseEntity<CarrinhoDTO> criarCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho novoCarrinho = carrinhoService.criarCarrinho(carrinho);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CarrinhoDTO(novoCarrinho));            
    }

    @GetMapping
    public ResponseEntity<List<CarrinhoDTO>> getCarrinhos() {
        List<Carrinho> carrinhos = carrinhoService.getCarrinhos();
        List<CarrinhoDTO> dto = carrinhos.stream().map(CarrinhoDTO::new).toList();
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDTO> getCarrinho(@PathVariable String id) {
        Carrinho carrinho = carrinhoService.getCarrinhoById(id);
        return ResponseEntity.ok(new CarrinhoDTO(carrinho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoDTO> atualizarCarrinho(@RequestBody Carrinho carrinho, @PathVariable String id) {
        Carrinho c = carrinhoService.atualizarCarrinho(id, carrinho);
        return ResponseEntity.ok(new CarrinhoDTO(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCarrinho(@PathVariable String id) {
        carrinhoService.deletarCarrinho(id);
        return ResponseEntity.ok("Carrinho deletado (id: " + id + ")");
    }

    @PutMapping("{carrinhoId}/item")
    public ResponseEntity<CarrinhoDTO> adicionarItem(@RequestBody Item item, @PathVariable String carrinhoId) {

        try {
            Carrinho carrinhoAtualizado = carrinhoService.adicionarItem(carrinhoId, item);
            return ResponseEntity.ok(new CarrinhoDTO(carrinhoAtualizado));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
