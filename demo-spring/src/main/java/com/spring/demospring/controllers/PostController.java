package com.spring.demospring.controllers;

import com.spring.demospring.repository.PostRepository;
import com.spring.demospring.models.Post;
import com.spring.demospring.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = " http://localhost:3001")
public class PostController
{

    //to unable swagger

    //here we create a repo object and autowired in spring will
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;


    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
        //here whenever someone calls the home page("/") we have to call the swagger API
        //in this application the swagger versions and spring versions are not compatible
        //spring 3.14 with swagger versions were not compatible
        //spring version changes to 2.5.7
    }

    @GetMapping("/allPosts")

    public List<Post>  getAllPosts()
    {

        //now we want to fetch all the data that has been stored
        return repo.findAll();//now we can fethc data
                //since we are using spring we can use the addes dependency
        //spring java mongodb to fetch all the stored data

    }
    //search through filter pipelines
    @GetMapping("/posts/{text}")

    public List<Post> search(@PathVariable String text)
    { //we need a method to find by text  ; so implemet the interface seachrepo inside repo package
        return srepo.findbyText(text);
    }

    //we want to post the jobposts
    @PostMapping("/post")//post is not same as posts

    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }



}
