package com.skcc.board.service.impl;

import com.skcc.board.domain.Comment;
import com.skcc.board.repository.CommentMapper;
import com.skcc.board.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public Comment registerComment(Comment comment) {
        comment.setCreatedDate(LocalDateTime.now());
        commentMapper.insertComment(comment);
        return comment;
    }

    @Override
    public List<Comment> findCommentByBoardId(Long boardId) {
        return commentMapper.selectCommentByBoardId(boardId);
    }
}
