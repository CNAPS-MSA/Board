package com.skcc.board.domain;

import com.skcc.board.domain.enumeration.Category;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdDate;
    private Category category;
    private int hit;
}
