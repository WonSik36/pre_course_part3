package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.board.entity.Member;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    @Commit
    @Test
    public void insertMembers() {
        IntStream.rangeClosed(201,300).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@aaa.com")
                    .password("1111")
                    .name("USER"+i)
                    .build();

            System.out.println("--------------- Start ---------------");
            memberRepository.save(member);
            System.out.println("--------------- End ---------------");
        });
    }
}