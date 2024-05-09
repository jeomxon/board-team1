package com.board.post;

import com.board.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    // 컨트롤러랑 레스트컨트롤러의 차이
    // 컨트롤러는 만약 1을 받았다면 1을 갖고 어떠한 처리
    // 레스트컨트롤러는 그냥 1을 다시 리턴
    // RestController를 쓰면 그게 바로 RestAPI
    // Rest를 명확하게 구분해서 확실하게 적용하면 RestfulAPI

    // title 제목
    // content 내용
    // userId 사용자ID

    // 어렵다

    private final UserRepository userRepository;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(
            Long id,
            @RequestBody PostCreateRequest postCreateRequest) {
        Long postId = postService.save(postCreateRequest.postId(),
                postCreateRequest.title(),
                postCreateRequest.content(),
                postCreateRequest.userId()
                );
        return ResponseEntity.created(URI.create("/posts" + postId)).build();
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable("postId") Long postId,
            @RequestBody PostUpdateRequest postUpdateRequest) {
        postService.updatePost(postUpdateRequest.userId(),
                postUpdateRequest.postId(),
                postUpdateRequest.title(),
                postUpdateRequest.content(),
                postUpdateRequest.memberId(),
                postUpdateRequest.createdDate());
    }

    @DeleteMapping("/{postId}")
    public void deletePost(Long userId, @PathVariable Long postId) {
        postService.delete(userId, postId);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getPostList() {
        List<PostResponse> postResponseList = postService.getPosts();
        return ResponseEntity.ok(postResponseList);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostResponse> getPostDetailInfo(
            @PathVariable Long postId
    ) {
        PostResponse post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }
}
