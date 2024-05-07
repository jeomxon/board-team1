package com.board.user;

import lombok.Getter;

@Getter
public class UserResponse {

    private final String username;
    private final String nickname;
    private final String name;

    public UserResponse(String username, String nickname, String name) {
        this.username = username;
        this.nickname = nickname;
        this.name = name;
    }
}
