package com.board.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @PutMapping("/{id}")
    public void update(
            Long memberId,
            Long id,
            @RequestBody MemoCreateRequest request) {
        memoService.update(memberId, id, request.title(), request.content());
    }

    @DeleteMapping("/{id}")
    public void delete(
            Long memberId,
            Long id
    ){
        memoService.delete(memberId, id);

    }


}
