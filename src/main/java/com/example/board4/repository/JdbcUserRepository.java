package com.example.board4.repository;

import com.example.board4.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepositroy {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update("INSERT INTO tbl_user(idx, email, name, deleted, updated, created) VALUES (null, ?, ?, ?, ?, ?)",
                new Object[]{user.getEmail(), user.getName(), user.getDeleted(), user.getUpdated(), user.getCreated()});
    }

    @Override
    public User detailUser(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_user WHERE idx = ?", BeanPropertyRowMapper.newInstance(User.class), id);
    }

    @Override
    public List<User> userAll() {
        return jdbcTemplate.query("SELECT * FROM tbl_user", BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update("UPDATE tbl_user SET email = ?, updated = ? WHERE idx = ?",
                new Object[]{user.getEmail(), user.getUpdated(), user.getIdx()});
    }

    @Override
    public int deleteUser(Long id) {
        return jdbcTemplate.update("DELETE FROM tbl_user WHERE idx = ?", id);
    }
}
