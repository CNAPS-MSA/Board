package com.skcc.board.domain;

import com.skcc.board.domain.enumeration.Category;
import lombok.Data;



@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private String writerName;
    private Long writerId;
    private String createdDate;
    private Category category;
    private int hit;
    private int commentCnt;

}
