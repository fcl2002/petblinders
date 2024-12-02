package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.dto.ItemDTO;
import com.ninja.startup.marketplace.petblinders.dto.TagDTO;
import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.entity.Tag;
import com.ninja.startup.marketplace.petblinders.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public Tag addTag(Tag tag) {
		
		String nomeFormatado = formatTagName(tag.getNome());

		if (tagRepository.existsByNomeIgnoreCase(nomeFormatado))
			throw new IllegalArgumentException("Tag already exists with name: " + tag.getNome());
		
		tag.setNome(nomeFormatado);
		return tagRepository.save(tag);
	}
	
	public String formatTagName(String nome) {
			
		if(nome.isBlank() || nome == null)
			throw new IllegalArgumentException("Tag name cannot be blank or null");

		nome = nome.trim().toLowerCase();
		return nome.substring(0, 1).toUpperCase() + nome.substring(1);
	}
	
	public List<TagDTO> findAll() {

		List<Tag> tags = tagRepository.findAll();
		List<TagDTO> dto = tags.stream().map(TagDTO::new).toList();
		return dto;
	}
	
	public void deleteTag(String id) {
		Tag tag = tagRepository.findById(id)
					.orElseThrow(()-> new NoSuchElementException("Tag not found with id: " + id));
		
		tagRepository.delete(tag);
	}
	
	public Tag updateTag(String id, Tag request) {	
		Tag tag = tagRepository.findById(id)
				   	.orElseThrow(()->new NoSuchElementException("Tag not found with id: "+id));

		String nomeFormatado = formatTagName(request.getNome());
		
		if (tagRepository.existsByNomeIgnoreCase(nomeFormatado))
			throw new IllegalArgumentException("Tag already exists with name: " + request.getNome());
		
		tag.setNome(nomeFormatado);
		return tagRepository.save(tag);
	}

	public List<ItemDTO> findByTag(String id){
		Tag tag = tagRepository.findById(id).get();
		
		List<Item> itens = tag.getItens();
		
		List<ItemDTO> dto = itens.stream().map(ItemDTO::new).toList();
		
		return dto;
	}
}
