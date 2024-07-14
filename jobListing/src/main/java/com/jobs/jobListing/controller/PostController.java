package com.jobs.jobListing.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobs.jobListing.model.Post;
import com.jobs.jobListing.repository.PostRepository;
import com.jobs.jobListing.repository.SearchRepository;
import com.jobs.jobListing.repository.SearchRepositoryImplementation;

import springfox.documentation.annotations.ApiIgnore;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController extends SearchRepositoryImplementation{
	
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@ApiIgnore
	@RequestMapping (value = "/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");		
	}
	
	@GetMapping ("/allPosts")
	@CrossOrigin
	public List<Post> getAllPosts() {
		return repo.findAll();
		
	}
	
	@GetMapping ("/posts/{text}")
	@CrossOrigin
	public List<Post> search(@PathVariable String text) {
		return srepo.findByText(text);
	}
	
	@PostMapping("/post")
	@CrossOrigin
	public Post addPost(@RequestBody Post post) {
		
		return repo.save(post);		
	}
	
	
}
