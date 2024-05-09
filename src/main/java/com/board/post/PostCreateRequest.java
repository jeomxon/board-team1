package com.board.post;

import java.time.LocalDate;

public record PostCreateRequest (Long postId,
                                String title,
                                String content,
                                String memberId,
                                LocalDate createdDate,
                                 Long userId){
}
