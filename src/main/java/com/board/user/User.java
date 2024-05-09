package com.board.user;

import com.board.common.UnAuthorizedException;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class User {

    private Long id;
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void login(String password) {
        if (this.password.equals(password)) {
            return;
        } else {
            throw new UnAuthorizedException("비밀번호 불일치 ..!");
        }
    }
}
