package com.skcc.board.service;

import com.skcc.board.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment registerComment(Comment comment);
    List<Comment> findCommentByBoardId(Long boardId, int pageNo, int pageSize);
    void deleteComment(Long id);
    Comment findCommentById(Long id);

    Comment editComment(Comment comment);
}
