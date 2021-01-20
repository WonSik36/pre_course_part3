package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder().email("user"+i+"@aaa.com").build();

            Board board = Board.builder()
                    .title("Title..."+i)
                    .content("Content..."+i)
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }

    @Transactional
    @Test
    public void testRead1() {
        Board board = boardRepository.findById(100L).orElseThrow();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWithWriter() {
        Object result = boardRepository.getBoardWithWriter(100L);

        Object[] arr = (Object[]) result;

        System.out.println("------------------------");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testGetBoardWithReply() {
        List<Object[]> result = boardRepository.getBoarWithReply(100L);

        for(Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testGetBoardWithReplyCount() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            System.out.println(Arrays.toString(row));
        });
    }

    @Test
    public void testRead3() {
        Object result = boardRepository.getBoardByBno(100L);

        Object[] arr = (Object[])result;

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSearch1() {
        boardRepository.search1();
    }
}