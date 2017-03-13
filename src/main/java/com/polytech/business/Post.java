package com.polytech.business;

/**
 * Created by daivietquochoang on 13/03/2017.
 */
public class Post {
    private String content;

    public Post(String content){this.content = content;}


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
