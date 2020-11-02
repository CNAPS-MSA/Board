package com.skcc.board;

import com.skcc.board.domain.Board;
import com.skcc.board.domain.enumeration.Category;
import com.skcc.board.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void boardTest() {
        Board board = new Board();
        board.setCategory(Category.NORMAL);
        board.setContent("test content");
        board.setCreatedDate(LocalDateTime.now());
        board.setHit(123);
        board.setTitle("test title");
        board.setWriter("test writer");
        boardService.addNewBoard(board);

        for (Board b : boardService.findAllBoard())
            System.out.println(b);
    }

}
