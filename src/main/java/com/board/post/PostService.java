package com.board.post;

import com.board.user.User;
import com.board.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 여기서부터 메서드 작성 ??
    // 해야 하는데 못 했습니다 ..

    public Long save(Long postId, String title, String content, Long userId) {
        // 유저 레포지토리에서 유저 찾고 ?
        User user = userRepository.findById(userId)
                .orElseThrow();

        // 포스트 찾고 ?
        Post post = postRepository.findById(postId)
                .orElseThrow();

        // 리턴
        return postRepository.savePost(post)
                .getPostId();
    }

    public void updatePost(Long userId, Long postId, String title, String content, String memberId, LocalDate createdDate) {
        // 유저 찾고
        User user = userRepository.findById(userId)
                .orElseThrow();

        // 포스트를 유저로 찾고
        Post post = postRepository.findById(userId)
                .orElseThrow();

        // 업뎃하고
        post.update(postId, title, content, memberId, createdDate);
    }

    public void delete(Long userId, Long postId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        Post post = postRepository.findById(postId)
                .orElseThrow();

        postRepository.deletePost(post);
    }

    public List<PostResponse> getPosts() {
        List<Post> postList = postRepository.findAllPost();
        return postList.stream()
                .map(post -> new PostResponse(post.getPostId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getMemberId(),
                        post.getCreatedDate()))
                .toList();
    }

    public PostResponse getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow();

        return new PostResponse(post.getPostId(), post.getTitle(), post.getContent(),
                post.getMemberId(), post.getCreatedDate());
    }
}
