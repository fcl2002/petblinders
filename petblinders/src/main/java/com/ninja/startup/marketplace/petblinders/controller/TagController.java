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

import com.ninja.startup.marketplace.petblinders.dto.ItemDTO;
import com.ninja.startup.marketplace.petblinders.dto.TagDTO;
import com.ninja.startup.marketplace.petblinders.entity.Tag;
import com.ninja.startup.marketplace.petblinders.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
	@Autowired
	private TagService tagService;
	
	@GetMapping
	public ResponseEntity<List<TagDTO>> findAll() {
		List<TagDTO> dtos = tagService.findAll();
		return ResponseEntity.ok(dtos);
	}
	
	@PostMapping
	public Tag addTag(@RequestBody Tag tag) {
		return tagService.addTag(tag);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tag> updateTag(@RequestBody Tag tag, @PathVariable String id){
		return ResponseEntity.ok(tagService.updateTag(id, tag));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteTag(@PathVariable String id){
		tagService.deleteTag(id);
		return ResponseEntity.ok("Tag deletada (id: " + id + ")");
	}

	@GetMapping(value = "/{id}/itens")
	public ResponseEntity<List<ItemDTO>> findByTag(@PathVariable String id) {
		List<ItemDTO> dtos = tagService.findByTag(id);
		return ResponseEntity.ok(dtos);
	}
}
