package com.example.board4.domain;

import java.util.Date;

public class Post {
    private Long idx;
    private Long userIdx;
    private Long boardIdx;
    private String title;
    private String description;
    private String deleted;
    private Date updated = new Date();
    private Date created = new Date();

    public Post() {
    }

    public Post(Long userIdx, Long boardIdx, String title, String description, String deleted, Date updated, Date created) {
        this.userIdx = userIdx;
        this.boardIdx = boardIdx;
        this.title = title;
        this.description = description;
        this.deleted = deleted;
        this.updated = updated;
        this.created = created;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public Long getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(Long boardIdx) {
        this.boardIdx = boardIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
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
