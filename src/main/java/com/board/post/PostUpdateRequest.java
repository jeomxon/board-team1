package com.board.post;

import java.time.LocalDate;

public record PostUpdateRequest(Long userId,
                                Long postId,
                                String title,
                                String content,
                                String memberId,
                                LocalDate createdDate){
}
