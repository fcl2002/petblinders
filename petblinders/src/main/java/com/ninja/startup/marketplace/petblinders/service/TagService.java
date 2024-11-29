package com.ninja.startup.marketplace.petblinders.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja.startup.marketplace.petblinders.dto.TagDTO;
import com.ninja.startup.marketplace.petblinders.entity.Tag;
import com.ninja.startup.marketplace.petblinders.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public Tag addTag(Tag tag) {	
		return tagRepository.save(tag);
	}
	
	public List<TagDTO> findAll(){
		List<Tag> tags = tagRepository.findAll();
		
		List<TagDTO> dto = tags.stream().map(TagDTO::new).toList();
		
		return dto;
	}
	
	public void deleteTag(String id) {
		Tag tag = tagRepository.findById(id)
				.orElseThrow(()-> new NoSuchElementException("tag not found with id: " + id));
		
		tagRepository.delete(tag);
	}
	
	public Tag updateTag(String id, Tag request) {	
		Tag tag = tagRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException("tag not found with id: "+id));
		tag.setNome(request.getNome());
		tagRepository.save(tag);
		return tag;
	}
}
