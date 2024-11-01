package com.geca.alumniCircle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geca.alumniCircle.model.Story;
import com.geca.alumniCircle.service.StoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("*")
@RequestMapping("/api/success-stories")
public class StoryController {
	
	@Autowired
	StoryService storyService;
	
	@GetMapping("")
	public List<Story> getMethodName() {
		return storyService.getAllStory();
	}
	
	@GetMapping("/{id}")
	public Optional<Story> getMethodName(@PathVariable Long id) {
		return storyService.getStory(id);
	}
	
	@PostMapping("/add")
	public Story postMethodName(@RequestBody Story story) {
		return storyService.addStory(story);
	}
	
	@PutMapping("/update/{id}")
	public Story putMethodName(@RequestBody Story story) {
		return storyService.updateStory(story);
	}
	
	@PutMapping("/update")
	public Story updateMethodName(@RequestBody Story story) {
		return storyService.updateStory(story);
	}
	
	@DeleteMapping("/delete/{id}")
	public Optional<Story> deleteStory(@PathVariable Long id) {
		Optional<Story> story = storyService.getStory(id);
		storyService.deleteStory(id);
		return story;
	}
 	
	
	
	
	
}
