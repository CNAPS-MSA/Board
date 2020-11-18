package com.skcc.board.service.impl;

import com.github.pagehelper.PageHelper;
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
    public List<Comment> findCommentByBoardId( Long boardId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return commentMapper.selectCommentByBoardId(boardId);
    }

    @Override
    public void deleteComment(Long id) {
        commentMapper.deleteComment(id);
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentMapper.selectCommentById(id);
    }

    @Override
    public Comment editComment(Comment comment) {
        commentMapper.updateComment(comment);
        return commentMapper.selectCommentById(comment.getId());
    }
}
