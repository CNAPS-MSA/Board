package com.skcc.board.web.rest;

import com.skcc.board.domain.Board;
import com.skcc.board.service.BoardService;
import com.skcc.board.web.rest.errors.BadRequestAlertException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardResource {
    private final Logger log = LoggerFactory.getLogger(BoardResource.class);
    private final BoardService boardService;
    private static final String ENTITY_NAME = "boardBoard";

   // @Value("${jhipster.clientApp.name}")
    //private String applicationName;
    public BoardResource(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public ResponseEntity<Board> addNewBoard(@RequestBody Board board) throws URISyntaxException {
        log.debug("REST request to save Book : {}", board);
        if (board.getId() != null) {
            throw new BadRequestAlertException("A new book cannot already have an ID", ENTITY_NAME, "idexists");
        }
        boardService.addNewBoard(board);
        // result = bookMapper.toDto(newBook);
        return ResponseEntity.ok().body(board);
    }

    @GetMapping("/board")
    public ResponseEntity<List<Board>> findBoard(){
        log.debug("REST request to find Books");
        List<Board> boards  = boardService.findAllBoard();
        return ResponseEntity.ok().body(boards);
    }
}
