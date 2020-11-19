package com.skcc.board.repository;

import com.github.pagehelper.Page;
import com.skcc.board.domain.Board;

import com.skcc.board.domain.enumeration.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {
    Board selectBoardById(Long id);
    Page<Board> selectAllBoard();
    void insertBoard(Board board);
    void updateBoard(Board board);
    Page<Board> selectBoardByCategory(Category category);
    void deleteBoard(Long id);
    void increaseHit(Long id);
}
