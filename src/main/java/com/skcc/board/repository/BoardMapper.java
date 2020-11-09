package com.skcc.board.repository;

import com.github.pagehelper.Page;
import com.skcc.board.domain.Board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {
    Board selectBoardById(Long id);
    Page<Board> selectAllBoard();
    void insertBoard(Board board);
    void updateBoard(Board board);
}
