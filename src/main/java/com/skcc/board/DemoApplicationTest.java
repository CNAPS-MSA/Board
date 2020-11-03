package com.skcc.board;

import com.skcc.board.domain.Board;
import com.skcc.board.domain.enumeration.Category;
import com.skcc.board.service.BoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    private BoardService boardService;

    private Board board;

    @Before
    public void setUp(){
        board = new Board();
        board.setCategory(Category.NORMAL);
        board.setContent("test content");
        board.setCreatedDate(LocalDateTime.now());
        board.setHit(123);
        board.setTitle("test title");
        board.setWriter("test writer");
        boardService.addNewBoard(board);
    }
    @Test
    public void boardTest() {

        Board findBoard = boardService.findBoardById(1L);
        assertThat(board.getContent(), is(equalTo(findBoard.getContent())));
        System.out.println(findBoard);
    }

}
