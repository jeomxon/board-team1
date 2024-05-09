package com.board.post;

import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Post {

    private Long postId;
    private String title;
    private String content;
    private String memberId;
    private LocalDate createdDate;

    // 여기서부터 .. 작성
    public Post(Long postId, String title, String content, String memberId, LocalDate createdDate) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.createdDate = createdDate;
    }

    public void setId(Long posrtId) {
        this.postId = posrtId;
    }

    public Long getPostId() {
        return postId;
    }

    public void update(Long postId, String title, String content, String memberId, LocalDate createdDate) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.createdDate = createdDate;
    }
}
