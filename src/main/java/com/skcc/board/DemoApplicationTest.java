package com.skcc.board;

import com.github.pagehelper.Page;
import com.skcc.board.domain.Board;
import com.skcc.board.domain.Comment;
import com.skcc.board.domain.enumeration.Category;
import com.skcc.board.repository.BoardMapper;
import com.skcc.board.service.BoardService;
import com.skcc.board.service.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private CommentService commentService;

    private Board board;
    private Board board2;
    private Comment comment1;

    private Comment comment2;

    private Comment comment3;

    @Before
    public void setUp(){
        board = new Board();
        board.setCategory(Category.NORMAL);
        board.setContent("test content");
        board.setHit(123);
        board.setTitle("test title");
        board.setWriterName("test writer");
        board.setWriterId(1L);
        boardService.registerNewBoard(board);

        board2 = new Board();
        board2.setCategory(Category.NOTICE);
        board2.setContent("test content");
        board2.setHit(123);
        board2.setTitle("test title");
        board2.setWriterName("test writer");
        board2.setWriterId(1L);
        boardService.registerNewBoard(board2);

        comment1 = new Comment();
        comment1.setBoardId(board.getId());
        comment1.setContent("comment 1");
        comment1.setWriterId(2L);
        comment1.setWriterName("comment writer");
        comment1=commentService.registerComment(comment1);

        comment2 = new Comment();
        comment2.setBoardId(board2.getId());
        comment2.setContent("comment 2");
        comment2.setWriterId(3L);
        comment2.setWriterName("comment writer222");
        comment2= commentService.registerComment(comment2);

        comment3 = new Comment();
        comment3.setBoardId(board2.getId());
        comment3.setContent("comment 3");
        comment3.setWriterId(4L);
        comment3.setWriterName("comment writer3333");
        comment3=commentService.registerComment(comment3);

    }
    @Test
    public void boardTest() {
        Board findBoard = boardService.findBoardById(1L);
        assertThat(board.getId(), is(equalTo(findBoard.getId())));
        System.out.println(findBoard);

        Page<Board> findBoardByCategory = boardService.findBoardsByCategory(0,1,Category.NORMAL);

        for(Board b: findBoardByCategory){
            System.out.println(b);
        }


    }

    @Test
    public void commentTest(){
        boardService.deleteBoard(board.getId());
        List<Comment> commentList = commentService.findAll();
        for(Comment c:commentList){
            System.out.println("###"+c);
        }
    }

}
