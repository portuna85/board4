package com.example.board4.controller;

import com.example.board4.domain.Board;
import com.example.board4.domain.User;
import com.example.board4.repository.BoardRepository;
import com.example.board4.repository.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v4")
public class BoardController {

    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userRepositroy.createUser(new User(user.getEmail(), user.getName(), user.getDeleted()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/board")
    public ResponseEntity<String> createBoard(@RequestBody Board board) {
        boardRepository.creatBoard(new Board(board.getTitle(), board.getType(), board.getUpdated(), board.getCreated()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> detailsUser(@PathVariable("id") long id) {
        return new ResponseEntity<>(userRepositroy.detailUser(id), HttpStatus.OK);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Board> detailsBoard(@PathVariable("id") long id) {
        return new ResponseEntity<>(boardRepository.detailBoard(id), HttpStatus.OK);
    }

    @GetMapping("/boards")
    public List<Board> listBoard() {
        return boardRepository.listBoard();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable("id") long id) {
        User user1 = userRepositroy.detailUser(id);

        user1.setEmail(user.getEmail());
        user1.setUpdated(user1.getUpdated());
        userRepositroy.updateUser(user1);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<String> updateBoard(@RequestBody Board board, @PathVariable("id") long id) {
        Board board1 = boardRepository.detailBoard(id);
        if (board1 != null) {
            board1.setTitle(board.getTitle());
            board1.setType(board.getType());
            boardRepository.updateBoard(board1);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        User user1 = userRepositroy.detailUser(id);

        userRepositroy.deleteUser(user1.getIdx());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable ("id") long id) {
        try {
            if (boardRepository.deleteBoard(id) == 0) {
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}