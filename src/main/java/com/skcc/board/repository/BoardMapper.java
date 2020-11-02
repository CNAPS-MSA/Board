package com.skcc.board.repository;

import com.skcc.board.domain.Board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    Board selectBoardById(Long id);
    List<Board> selectAllBoard();
    void insertBoard(Board board);
}
