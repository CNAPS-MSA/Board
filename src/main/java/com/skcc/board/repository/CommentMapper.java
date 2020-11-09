package com.skcc.board.repository;

import com.skcc.board.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    void insertComment(Comment comment);
    Comment selectCommentById(Long id);
    List<Comment> selectCommentByBoardId(Long boardId);
}
