package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    @Commit
    @Test
    public void insertReply() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            long bno = (long)(Math.random()*100) + 1;

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .text("Reply....."+i)
                    .board(board)
                    .replyer("guest")
                    .build();

            System.out.println("--------------- Start ---------------");
            replyRepository.save(reply);    // GenerationType.IDENTITY 로 인해 계속 삽입
            System.out.println("--------------- End ---------------");
        });
    }

    @Test
    public void readReply1() {
        Reply reply = replyRepository.findById(1L).orElseThrow();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }

    @Test
    public void testListByBoard() {
        List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(97L).build());

        replyList.forEach(System.out::println);
    }
}