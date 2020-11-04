package com.skcc.board.domain;

import com.skcc.board.domain.enumeration.Category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private Long writer_id;
    private LocalDateTime createdDate;
    private Category category;
    private int hit;
}
