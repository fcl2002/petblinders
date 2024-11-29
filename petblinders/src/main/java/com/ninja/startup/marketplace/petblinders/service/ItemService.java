package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.dto.ItemDto;
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
	
	public List<ItemDto> findAll(){
		List<Item> itens = itemRepository.findAll();
		List<ItemDto> dto = itens.stream().map(ItemDto::new).toList();
		return dto;
	}
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public Item findByNome(String nome) {
		return itemRepository.findByNome(nome).get();
	}
	
	public ItemDto findById(String id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException("Item not found with id: " + id));
		ItemDto dto = new ItemDto(item);
		return dto;
	}
	
	public void deleteItem(String id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException("Item not found with id: " + id));
		itemRepository.delete(item);
	}
	
	public Item updadeItem(Item request, String id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException("Item not found with id: " + id));
		if(request.getNome() != null)
			item.setNome(request.getNome());
		
		if(request.getDescricao() != null)
			item.setDescricao(request.getDescricao());
		
		return itemRepository.save(item);
	}
	
	public void addTag(String idTag, String idItem) {
		Item item = itemRepository.findById(idItem)
				.orElseThrow(()->new NoSuchElementException("Item not found with id: " + idItem));
		Tag tag = tagRepository.findById(idTag)
				.orElseThrow(()-> new NoSuchElementException("Tag not found with id: "+idTag));
		item.getTags().add(tag);
		tag.getItens().add(item);
		
		tagRepository.save(tag);
		itemRepository.save(item);
	}
}
