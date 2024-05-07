package com.board.board;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Post {

    private Long id;
    private String title;
    private String content;
    private String memberId;
    private LocalDate createdDate;

    // 여기서부터 .. 작성
    public Post(Long id, String title, String content, String memberId, LocalDate createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.createdDate = createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
