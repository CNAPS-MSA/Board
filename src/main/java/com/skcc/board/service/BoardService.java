package com.skcc.board.service;

import com.skcc.board.domain.Board;

import java.util.List;

public interface BoardService {

    public Board findBoardById(Long id);

    public List<Board> findAllBoard();

    public void addNewBoard(Board board);

}
