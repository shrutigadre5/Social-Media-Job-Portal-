package com.jobs.jobListing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.jobs.jobListing.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	

}
