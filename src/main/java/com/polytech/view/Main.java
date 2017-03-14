package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by daivietquochoang on 13/03/2017.
 */
public class Main {

    public static void main(String[] args) {
        // System.out.println("coucou polytech");

        //PublicationService publicationService = new PublicationServiceImpl(repository);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PublicationService publicationService = applicationContext.getBean(PublicationService.class);


        Post post = new Post("Luminy est cool");
        Post post2= new Post("Lumini est cool 2");
        publicationService.post(post);
        publicationService.post(post2);

        List<Post> posts = publicationService.fetchAll();
        System.out.println(posts);

    }
}
