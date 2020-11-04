package com.skcc.board.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private String content;
    private String writerName;
    private Long writerId;
    private LocalDateTime createdDate;
    private Long boardId;

}
