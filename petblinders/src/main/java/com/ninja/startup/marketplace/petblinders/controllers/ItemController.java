package com.ninja.startup.marketplace.petblinders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.startup.marketplace.petblinders.entitys.Item;
import com.ninja.startup.marketplace.petblinders.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping
	public List<Item> findAll(){
		return itemService.findAll();
	}
	
	@PostMapping
	public void addItem(@RequestBody Item item) {
		itemService.addItem(item);
	}
	
	@PutMapping(value = "/{id}")
	public Item updateItem(@RequestBody Item item, @PathVariable String id) {
		
		return itemService.updadeItem(item, id);
	}
	
	@GetMapping(value = "/{id}")
	public Item findByid(@PathVariable String id) {
		return itemService.findById(id);
	}
	
	@GetMapping(value = "/name/{nome}")
	public Item findByName(@PathVariable String nome) {
		return itemService.findByNome(nome);
	}
	
	@DeleteMapping(value = "{id}")
	public void deleteItem(@PathVariable String id) {
		itemService.deleteItem(id);
	}
}
