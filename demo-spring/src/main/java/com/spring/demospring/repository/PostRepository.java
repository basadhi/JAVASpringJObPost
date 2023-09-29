package com.spring.demospring.repository;

import com.spring.demospring.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String>
{
    //without writing any queries and lines we can fetch data
    //here we do not need to write any queries for CRUD operations
    // they will be done by mongodb spring dependency
    //here we have the ability to do all the CRUD operations since we are implementing the mongodbrepo class




}
