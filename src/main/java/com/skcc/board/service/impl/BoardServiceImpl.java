package com.skcc.board.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.skcc.board.domain.Board;
import com.skcc.board.repository.BoardMapper;
import com.skcc.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public Board findBoardById(Long id) {
        return boardMapper.selectBoardById(id);
    }

    @Override
    public Page<Board> findAllBoard(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return boardMapper.selectAllBoard();
    }

    @Override
    public void addNewBoard(Board board) {
        board.setCreatedDate(LocalDateTime.now());
        boardMapper.insertBoard(board);
    }
}
