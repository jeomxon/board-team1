package com.board.user;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private final Map<Long, User> users = new HashMap<>();
    private Long id = 1L;

    // 미구현 상태

    public User save(User user) {
        user.setId(id);
        users.put(id++, user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public Optional<User> findByName(String username) {
        return users.values()
                .stream()
                .filter(it -> it.getUsername().equals(username))
                .findAny();
    }
}
