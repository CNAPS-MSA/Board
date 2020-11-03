package com.skcc.board.service;

import com.skcc.board.domain.Board;

import java.util.List;

public interface BoardService {

    Board findBoardById(Long id);

    List<Board> findAllBoard();

    void addNewBoard(Board board);

}
