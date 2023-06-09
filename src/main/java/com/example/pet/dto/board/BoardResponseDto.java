package com.example.pet.dto.board;

import com.example.pet.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardResponseDto {
    private int postId;
    private String title;
    private String content;
    private String writer;
    private int memberId;
    private String category;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public BoardResponseDto(Board board) {
        this.postId = board.getPostId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.category = board.getCategory();
        this.writer = board.getWriter();
        this.memberId = board.getMember().getMemberId();
        this.createdDate = board.getCreatedDate();
        this.lastModifiedDate = board.getLastModifiedDate();
    }
}
