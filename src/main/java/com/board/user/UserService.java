package com.board.user;

import com.board.common.ConflictException;
import com.board.common.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long signup(String username, String password, String name) {
        userRepository.findByName(username)
                .ifPresent(it -> {
                    throw new ConflictException("이미 있는 아이디");
                });

        User user = new User(username, password, name);

        return userRepository.save(user)
                .getId();
    }

    public Long login(String username, String password) {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new UnAuthorizedException("없는 아이디 ..!"));
        user.login(password);

        return user.getId();
    }
}
