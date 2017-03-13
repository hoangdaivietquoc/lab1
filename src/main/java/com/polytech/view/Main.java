package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.repository.PostRepository;

import java.util.List;

/**
 * Created by daivietquochoang on 13/03/2017.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("coucou polytech");
        PostRepository repository = new PostRepository();
        PublicationService publicationService = new PublicationService(repository);
        Post post = new Post("Luminy est cool");
        publicationService.post(post);

        List<Post> posts = publicationService.fetchAll();
        System.out.println(posts);

    }
}
