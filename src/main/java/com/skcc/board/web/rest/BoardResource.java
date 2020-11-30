package com.skcc.board.web.rest;

import com.github.pagehelper.Page;
import com.skcc.board.domain.Board;
import com.skcc.board.domain.enumeration.Category;
import com.skcc.board.repository.BoardMapper;
import com.skcc.board.service.BoardService;
import com.skcc.board.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardResource {
    private final Logger log = LoggerFactory.getLogger(BoardResource.class);
    private final BoardService boardService;
    private static final String ENTITY_NAME = "boardBoard";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    public BoardResource(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public ResponseEntity<Board> addNewBoard(@RequestBody Board board) throws URISyntaxException {
        log.debug("REST request to save board : {}", board);
        if (board.getId() != null) {
            throw new BadRequestAlertException("A new board cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Board result = boardService.registerNewBoard(board);

        return ResponseEntity.created(new URI("/api/board/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @GetMapping("/board")
    public ResponseEntity<List<Board>> findAllBoard(@RequestParam(value = "page")int pageNo, @RequestParam(value = "size") int pageSize){
        log.debug("REST request to find boards");
        List<Board> boards  = boardService.findAllBoard(pageNo, pageSize);
        return ResponseEntity.ok().body(boards);
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<Board> findBoard(@PathVariable Long boardId){
        log.debug("REST request to find board:  boardId}");
        Board board  = boardService.findBoardById(boardId);
        return ResponseEntity.ok().body(board);
    }

    @GetMapping("/board/category/{category}")
    public ResponseEntity<List<Board>> findBoardByCategory(@PathVariable("category") Category category, @RequestParam(value = "page")int pageNo, @RequestParam(value = "size") int pageSize ){
        log.debug("REST request to find board:  boardId}");
        List<Board> result = boardService.findBoardsByCategory(pageNo, pageSize,category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
        log.debug("REST request to delete board : {}", id);
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    @PutMapping("/board")
    public ResponseEntity<Board> editBoard(@RequestBody Board board){
        log.debug("REST request to update board:{}", board);
        if(board.getId()== null){
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Board editBoard = boardService.editBoard(board);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, editBoard.getId().toString())).body(editBoard);


    }
}
