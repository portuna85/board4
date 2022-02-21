package com.example.board4.repository;

import com.example.board4.domain.Post;
import com.example.board4.domain.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRepositroy {
    int createUser(User user);

    User detailUser(Long id);

    List<User> userAll();

    int updateUser(User user);

    int deleteUser(Long id);
}