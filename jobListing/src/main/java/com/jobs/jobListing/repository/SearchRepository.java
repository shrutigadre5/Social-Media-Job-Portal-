package com.jobs.jobListing.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jobs.jobListing.model.Post;


@Component
public interface SearchRepository {
	
	List <Post> findByText(String text);
}
