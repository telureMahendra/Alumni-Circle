package com.geca.alumniCircle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Story;
import com.geca.alumniCircle.repository.StoryRepository;

@Service
public class StoryService {
	
	@Autowired
	StoryRepository storyRepository;
	

	public Story addStory(Story story) {
		return storyRepository.save(story);
	}
	
	public Story updateStory(Story story) {
		return storyRepository.save(story);
	}
	
	public Optional<Story> getStory(long id) {
		return storyRepository.findById(id);
	}
	
	public List<Story> getAllStory(){
		return storyRepository.findAll();
	}
	
	public void deleteStory(long id) {
		storyRepository.deleteById(id);
	}
	
}
