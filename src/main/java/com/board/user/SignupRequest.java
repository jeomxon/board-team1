package com.board.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequest {
    // 이걸 활용해 보고 싶은데 잘 안 됩니다 .. ㅜ

    private String username;
    private String password;
    private String name;

    public SignupRequest(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
