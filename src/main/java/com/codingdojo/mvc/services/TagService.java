package com.codingdojo.mvc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.repositories.TagRepository;

@Service
public class TagService {
	
	@Autowired
	TagRepository tagRepository;
	
	// //// CREATE NEW TAG ///////////
	public Tag createTag(Tag newTag) {
		System.out.println("creating-new-tag");
		return tagRepository.save(newTag);
	}
	
	// //// FIND TAG BY ID ////////////
	public Tag findTagById(Long id) {
		System.out.println("************** GET TAG BY ID ***************");
		Optional<Tag> optional = tagRepository.findById(id);
		if (optional.isPresent()) {
			System.out.println("------------- TAG IS PRESENT -------------");
			return optional.get();
		} else {
			return null;
		}
	}
}
