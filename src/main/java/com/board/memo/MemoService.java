package com.board.memo;

import com.board.common.NotFoundException;
import com.board.member.Member;
import com.board.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    public Long save(Long userId, String title, String content) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("회원 정보가 없습니다."));
        Memo memo = new Memo(content, title, userId);
        return memoRepository.save(memo)
                .getId();
    }

    public void update(Long userId, Long id, String title, String content){
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("회원 정보가 없습니다."));
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시글이 존재하지 않습니다."));
        memo.validateMember(member);
        memo.update(title, content);
    }

    public void delete(Long userId, Long id){
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("회원 정보가 없습니다."));
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시글이 존재하지 않습니다."));
        memo.validateMember(member);
        memoRepository.delete(memo);

    }
}
