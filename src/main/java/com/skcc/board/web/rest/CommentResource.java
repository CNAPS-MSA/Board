package com.skcc.board.web.rest;

import com.skcc.board.domain.Board;
import com.skcc.board.domain.Comment;
import com.skcc.board.domain.enumeration.Category;
import com.skcc.board.service.CommentService;
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
public class CommentResource {
    private final Logger log = LoggerFactory.getLogger(CommentResource.class);
    private final CommentService commentService;
    private static final String ENTITY_NAME = "commentComment";

    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @PostMapping("/comment")
    public ResponseEntity<Comment> addNewComment(@RequestBody Comment comment) throws URISyntaxException {
        log.debug("REST request to save Comment : {}", comment);
        if (comment.getId() != null) {
            throw new BadRequestAlertException("A new comment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Comment result = commentService.registerComment(comment);

        return ResponseEntity.created(new URI("/api/comment/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @GetMapping("/comment/board/{boardId}")
    public ResponseEntity<List<Comment>> findAllCommentByBoardId( @PathVariable Long boardId){
        log.debug("REST request to find Comments");
        List<Comment> commentList  = commentService.findCommentByBoardId( boardId);
        return ResponseEntity.ok().body(commentList);
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<Comment> findComment(@PathVariable Long commentId){
        log.debug("REST request to find Comment: {commentId}");
        Comment comment  = commentService.findCommentById(commentId);
        return ResponseEntity.ok().body(comment);
    }


    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        log.debug("REST request to delete comment : {}", id);
        commentService.deleteComment(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    @PutMapping("/comment")
    public ResponseEntity<Comment> editComment(@RequestBody Comment comment){
        log.debug("REST request to update comment:{}", comment);
        if(comment.getId()== null){
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Comment result = commentService.editComment(comment);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,result.getId().toString())).body(result);


    }
}
