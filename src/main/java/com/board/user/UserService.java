package com.board.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long signup(String username, String password, String name) {
        return null;
    }

    public Long login(String username, String password) {
        return null;
    }
}
