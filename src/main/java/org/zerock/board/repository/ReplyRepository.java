package org.zerock.board.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> { }
