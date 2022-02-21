package com.example.board4.repository;

import com.example.board4.domain.Board;
import com.example.board4.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcBoardRepository implements BoardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int creatBoard(Board board) {
        return jdbcTemplate.update("INSERT INTO tbl_board(idx, title, type, updated, created) VALUES (null, ?, ?, ?, ?)",
                new Object[]{board.getTitle(), board.getType(), board.getUpdated(), board.getCreated()});
    }

    @Override
    public Board detailBoard(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_board WHERE idx = ? ",
                BeanPropertyRowMapper.newInstance(Board.class), id);
    }

    @Override
    public List<Board> listBoard() {
        return jdbcTemplate.query("SELECT * FROM tbl_board", BeanPropertyRowMapper.newInstance(Board.class));
    }

    @Override
    public int updateBoard(Board board) {
        return jdbcTemplate.update("UPDATE tbl_board SET title = ? , type = ? , updated = now() WHERE idx = ?",
                new Object[]{board.getTitle(), board.getType(), board.getIdx()});
    }

    @Override
    public int deleteBoard(Long id) {

        return jdbcTemplate.update("DELETE FROM tbl_board WHERE idx = ?", id);
    }
}
