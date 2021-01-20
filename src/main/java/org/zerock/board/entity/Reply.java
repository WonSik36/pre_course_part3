package org.zerock.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="reply")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    @JoinColumn(name="board_no")
    private Board board;
}
