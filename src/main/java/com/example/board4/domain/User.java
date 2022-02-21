package com.example.board4.domain;

import java.util.Date;

public class User {
    private long idx;
    private String email;
    private String name;
    private int deleted;
    private Date updated = new Date();
    private Date created = new Date();

    public User() {
    }

    public User(String email, String name, int deleted) {
        this.email = email;
        this.name = name;
        this.deleted = deleted;
    }

    public User(String email, String name, int deleted, Date updated, Date created) {
        this.email = email;
        this.name = name;
        this.deleted = deleted;
        this.updated = updated;
        this.created = created;
    }

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}