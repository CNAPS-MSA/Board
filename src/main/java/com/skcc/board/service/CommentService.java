package com.skcc.board.service;

import com.skcc.board.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment registerComment(Comment comment);
    List<Comment> findCommentByBoardId(Long boardId);
    void deleteComment(Long id);
    Comment findCommentById(Long id);
    List<Comment> findAll();
    Comment editComment(Comment comment);
}
