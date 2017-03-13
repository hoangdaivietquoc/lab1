package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 13/03/2017.
 */
public interface PublicationService {
    public void post(Post post);
    public List<Post> fetchAll();
}
