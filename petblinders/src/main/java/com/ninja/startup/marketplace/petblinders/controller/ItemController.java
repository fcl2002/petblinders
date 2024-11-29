package com.ninja.startup.marketplace.petblinders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping
	public void addItem(@RequestBody Item item) {
		itemService.addItem(item);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Item>> findAll() {
		List<Item> itens = itemService.findAll();
		return ResponseEntity.ok(itens);
	}
	
	@PutMapping("/{id}")
	public Item updateItem(@RequestBody Item item, @PathVariable String id) {
		
		return itemService.updadeItem(item, id);
	}
	
	@GetMapping("/{id}")
	public Item findByid(@PathVariable String id) {
		return itemService.findById(id);
	}
	
	@GetMapping("/name/{nome}")
	public Item findByName(@PathVariable String nome) {
		return itemService.findByNome(nome);
	}
	
	@DeleteMapping("{id}")
	public void deleteItem(@PathVariable String id) {
		itemService.deleteItem(id);
	}
	
	@PutMapping("/{idItem}/tags/{idTag}")
	public void addTag(@PathVariable String idTag, @PathVariable String idItem) {
		itemService.addTag(idTag, idItem);
	}
}
