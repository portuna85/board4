package com.example.board4.repository;

import com.example.board4.domain.Board;

import java.util.List;

public interface BoardRepository {
    int creatBoard(Board board);

    Board detailBoard(Long id);

    List<Board> listBoard();

    int updateBoard(Board board);

    int deleteBoard(Long id);
}
