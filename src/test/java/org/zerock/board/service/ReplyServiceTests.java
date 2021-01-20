package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.ReplyDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTests {
    @Autowired
    private ReplyService service;

    @Test
    public void testGetList() {
        Long bno = 100L;

        List<ReplyDto> replyDtoList = service.getList(bno);

        replyDtoList.forEach(System.out::println);
    }
}