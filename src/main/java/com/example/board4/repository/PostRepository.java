package com.example.board4.repository;

import com.example.board4.domain.Post;

import java.util.List;

public interface PostRepository {
    int createPost(Post post);

    Post detailPost(Long id);

    List<Post> listPost();

    int updatePost(Long id);

    int deletePost(Long id);
}
