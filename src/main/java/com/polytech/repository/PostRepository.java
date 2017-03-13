package com.polytech.repository;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by daivietquochoang on 13/03/2017.
 */
public interface PostRepository {
    public void save(Post post);

    public List<Post> findAll();
}
