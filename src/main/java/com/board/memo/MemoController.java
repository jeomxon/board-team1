package com.board.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/memos")
@RestController
public class MemoController {
    private final MemoService memoService;

    @PostMapping
    public ResponseEntity<Void> create(
            Long memberId,
            @RequestBody MemoCreateRequest request
    ) {
        Long id = memoService.save(memberId,request.title(),request.content());
        return ResponseEntity.created(URI.create("/posts/" + id)).build();

    }

}
