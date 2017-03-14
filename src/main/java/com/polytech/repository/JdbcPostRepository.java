package com.polytech.repository;

import com.polytech.business.Post;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daivietquochoang on 14/03/2017.
 */
public class JdbcPostRepository implements PostRepository {
    private DataSource dataSource;

    public JdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Post post) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1, post.getContent());
            preparedStatement.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Post> findAll() {
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM POST");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                posts.add(new Post(rs.getString("CONTENT")));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return posts;
    }
}
