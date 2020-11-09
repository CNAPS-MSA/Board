package com.skcc.board.service;

import com.github.pagehelper.Page;
import com.skcc.board.domain.Board;
import com.skcc.board.domain.Comment;

import java.util.List;

public interface BoardService {

    Board findBoardById(Long id);

    Page<Board> findAllBoard(int pageNo, int pageSize);

    Board registerNewBoard(Board board);

    Board editBoard(Board board);






}
