package com.spring.demospring.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spring.demospring.models.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

//here we need to add the monodb aggregation code here so that we need mongodb client
//but since we are using spring we dont need to specifically build it we can just Autowired it by spring itself

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//if my spring want to read this class in execution
@Component
public class SearchRepositoryImpl implements SearchRepository
{
    @Autowired
            //Autowired simply get the objects of the class
    MongoClient client;

    @Autowired
    MongoConverter converter;
    @Override
    public List<Post> findbyText(String text) {

        final List<Post>posts=new ArrayList<>();


        MongoDatabase database = client.getDatabase("springjob");
        MongoCollection<Document> collection = database.getCollection("joblist");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                        new Document("$search",
                        new Document("index", "default")
                        .append("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("techs", "profile", "desc")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));


        result.forEach(document -> posts.add(converter.read(Post.class,document)));


        return posts;



    }
}
