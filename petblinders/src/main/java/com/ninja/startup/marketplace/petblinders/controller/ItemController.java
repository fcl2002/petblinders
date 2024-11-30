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

import com.ninja.startup.marketplace.petblinders.dto.ItemDTO;
import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		Item novoItem = itemService.addItem(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
	}

	@GetMapping
	public ResponseEntity<List<ItemDTO>> findAll() {
		List<ItemDTO> itens = itemService.findAll();
		return ResponseEntity.ok(itens);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> findByid(@PathVariable String id) {
		ItemDTO item = itemService.findById(id);
		return ResponseEntity.ok(item);
	}

	@GetMapping("/name/{nome}")
	public ResponseEntity<ItemDTO> findByName(@PathVariable String nome) {
		ItemDTO item = itemService.findByNome(nome);
		return ResponseEntity.ok(item);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable String id) {
		Item novoItem = itemService.updadeItem(item, id);
		return ResponseEntity.ok(novoItem);
	}

	@PutMapping("/{idItem}/tags/{idTag}")
	public ResponseEntity<ItemDTO> addTag(@PathVariable String idTag, @PathVariable String idItem) {
		ItemDTO item = itemService.addTag(idTag, idItem);
		return ResponseEntity.ok(item);
	}
	
	@DeleteMapping("/{idItem}/tags/{idTag}")
	public ResponseEntity<ItemDTO> removeTag(@PathVariable String idTag, @PathVariable String idItem) {
		ItemDTO item = itemService.removeTag(idTag, idItem);
		return ResponseEntity.ok(item);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteItem(@PathVariable String id) {
		itemService.deleteItem(id);
		return ResponseEntity.ok("Item deletado (id: " + id + ")");
	}
}
