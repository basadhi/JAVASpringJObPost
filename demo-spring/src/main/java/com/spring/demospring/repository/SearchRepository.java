package com.spring.demospring.repository;

import com.spring.demospring.models.Post;

import java.util.List;

public interface SearchRepository
{
    List<Post> findbyText(String text);

}
