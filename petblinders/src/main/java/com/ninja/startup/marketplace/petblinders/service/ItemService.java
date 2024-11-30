package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.entity.Tag;
import com.ninja.startup.marketplace.petblinders.repository.ItemRepository;
import com.ninja.startup.marketplace.petblinders.repository.TagRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Item findByNome(String nome) {
		return itemRepository.findByNome(nome)
				.orElseThrow(()->new NoSuchElementException("Item not found with name: " + nome));
	}
	
	public Item findById(String id) {
		return itemRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException("Item not found with id: " + id));
	}
	
	public void deleteItem(String id) {
		Item item = findById(id);
		itemRepository.delete(item);
	}
	
	public Item updadeItem(Item request, String id) {
		Item item = findById(id);
		if(request.getNome() != null)
			item.setNome(request.getNome());
		
		if(request.getDescricao() != null)
			item.setDescricao(request.getDescricao());
		
		return itemRepository.save(item);
	}
	
	public void addTag(String idTag, String idItem) {
		Item item = findById(idItem);
		Tag tag = tagRepository.findById(idTag)
				.orElseThrow(()-> new NoSuchElementException("Tag not found with id: "+idTag));
		item.getTags().add(tag);
		tag.getItens().add(item);
		
		tagRepository.save(tag);
		itemRepository.save(item);
	}
}
