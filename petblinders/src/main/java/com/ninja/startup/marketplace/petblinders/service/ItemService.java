package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.dto.ItemDTO;
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
	
	public List<ItemDTO> findAll(){
		List<Item> itens = itemRepository.findAll();
		List<ItemDTO> dto = itens.stream().map(ItemDTO::new).toList();
		return dto;
	}
	
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}
	
	public ItemDTO findByNome(String nome) {
		Item item = itemRepository.findByNome(nome)
					 .orElseThrow(()->new NoSuchElementException("Item not found with name: " + nome));
		ItemDTO dto = new ItemDTO(item);
		return dto;
	}
	
	public ItemDTO findById(String id) {
		Item item = itemRepository.findById(id)
					 .orElseThrow(()->new NoSuchElementException("Item not found with id: " + id));
		ItemDTO dto = new ItemDTO(item);
		return dto;
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
	
	public ItemDTO addTag(String idTag, String idItem) {
		Item item = itemRepository.findById(idItem)
					 .orElseThrow(()->new NoSuchElementException("Item not found with id: " + idItem));
		Tag tag = tagRepository.findById(idTag)
					 .orElseThrow(()-> new NoSuchElementException("Tag not found with id: "+idTag));
		
		item.getTags().add(tag);
		tag.getItens().add(item);
		
		tagRepository.save(tag);
		itemRepository.save(item);
		ItemDTO dto = new ItemDTO(item);

		return dto;
	}

	public ItemDTO removeTag(String idTag, String idItem) {
		Item item = itemRepository.findById(idItem)
					 .orElseThrow(()->new NoSuchElementException("Item not found with id: " + idItem));
		Tag tag = tagRepository.findById(idTag)
					 .orElseThrow(()-> new NoSuchElementException("Tag not found with id: " + idTag));

		List<Tag> tags = item.getTags();
		for(Tag t : tags) {
			if(t.getId().equals(tag.getId())) {
				tags.remove(t);
				break;
			}
		}
		
		item.setTags(tags);
		itemRepository.save(item);

		List<Item> itens = tag.getItens();
		for(Item i : itens) {
			if(i.getId().equals(item.getId())) {
				itens.remove(i);
				break;
			}
		}
		
		tag.setItens(itens);
		tagRepository.save(tag);

		ItemDTO dto = new ItemDTO(item);

		return dto;
	}

	public void deleteItem(String id) {
		if(itemRepository.existsById(id))
			itemRepository.deleteById(id);
		else
			throw new NoSuchElementException("Item not found with id: " + id);
	}
}
