package com.ninja.startup.marketplace.petblinders.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.entitys.Item;
import com.ninja.startup.marketplace.petblinders.entitys.Tag;
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
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	public Item findByNome(String nome) {
		return itemRepository.findByNome(nome).get();
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
	
	public Item addTag(String idTag, String idItem) {
		Item item = findById(idItem);
		Tag tag = tagRepository.findById(idTag)
				.orElseThrow(()-> new NoSuchElementException("Tag not found with id: "+idTag));
		item.getTags().add(tag);
		tag.getItens().add(item);
		
		return itemRepository.save(item);
	}
}
