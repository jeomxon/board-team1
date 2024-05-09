package com.board.post;

import java.time.LocalDate;

public record PostResponse(
        Long userId,
        String title,
        String content,
        String memberId,
        LocalDate createdDate) {
}
