package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDto;
import org.zerock.board.dto.PageRequestDto;
import org.zerock.board.dto.PageResultDto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDto dto = BoardDto.builder()
                .title("Test.")
                .content("Test....")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);
    }

    @Test
    public void testList() {
        PageRequestDto pageRequestDto = new PageRequestDto();

        PageResultDto<BoardDto, Object[]> result = boardService.getList(pageRequestDto);

        for(BoardDto boardDto : result.getDtoList()) {
            System.out.println(boardDto);
        }
    }

    @Test
    public void testGet() {
        Long bno = 100L;

        BoardDto boardDto = boardService.get(bno);

        System.out.println(boardDto);
    }

    @Test
    public void testRemove() {
        Long bno = 1L;

        boardService.removeWithReplies(bno);
    }
}