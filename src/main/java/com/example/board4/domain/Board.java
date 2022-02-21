package com.example.board4.domain;

import java.util.Date;

public class Board {
    private long idx;
    private String title;
    private String type;
    private Date updated = new Date();
    private Date created = new Date();

    public Board() {
    }


    public Board(String title, String type, Date updated, Date created) {
        this.title = title;
        this.type = type;
        this.updated = updated;
        this.created = created;
    }

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
