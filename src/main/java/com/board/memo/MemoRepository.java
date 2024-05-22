package com.board.memo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoRepository {
    private final Map<Long, Memo> memos = new HashMap<>();
    private Long id = 1L;

    public Memo save(Memo memo) {
        memo.setId(id);
        memos.put(id++, memo);
        return memo;
    }


    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(memos.get(id));
    }

    public void delete(Memo memo){ memos.remove(memo.getId());}
}

