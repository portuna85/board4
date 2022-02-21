package com.example.board4.repository;

import com.example.board4.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPostRepository implements PostRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int createPost(Post post) {
        return jdbcTemplate.update("INSERT INTO tbl_post(idx,userIdx, boardIdx, title, description, deleted, updated, created) VALUES (null,?, ?, ?, ?, ?, ?, ?)",
                new Object[]{post.getUserIdx(), post.getBoardIdx(), post.getTitle(), post.getDescription(), post.getDeleted(), post.getUpdated(), post.getCreated()});
    }

    @Override
    public Post detailPost(Long id) {
        return null;
    }

    @Override
    public List<Post> listPost() {
        return null;
    }

    @Override
    public int updatePost(Long id) {
        return 0;
    }

    @Override
    public int deletePost(Long id) {
        return 0;
    }
}
