package com.board.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping
public class UserController {
    // User 도메인 관련 클래스
    // 회원가입 Request Body: username, password, name
    // 로그인 Request Body: username, password

    private UserService userService;

    @ResponseStatus(CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        userService.signup(
                request.getUsername(),
                request.getPassword(),
                request.getName()
        );
    }

    @PostMapping("/login")
    public void login(@RequestBody SignupRequest request) {
        userService.login(
                request.getUsername(),
                request.getPassword());
    }
}
