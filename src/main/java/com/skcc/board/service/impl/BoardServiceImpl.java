package com.skcc.board.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.skcc.board.domain.Board;
import com.skcc.board.domain.Comment;
import com.skcc.board.domain.enumeration.Category;
import com.skcc.board.repository.BoardMapper;
import com.skcc.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    //게시글 조회
    @Override
    public Board findBoardById(Long id) {
        return boardMapper.selectBoardById(id);
    }

    //게시글 전체(목록) 조회
    @Override
    public Page<Board> findAllBoard(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return boardMapper.selectAllBoard();
    }

    //게시글 등록
    @Override
    public Board registerNewBoard(Board board) {
        board.setCreatedDate(LocalDateTime.now()); //생성 날짜 현재 날짜로 세팅
        board.setHit(0); //최초 등록시 조회수 0으로 설정
        boardMapper.insertBoard(board);
        return board;
    }

    //게시글 수정
    @Override
    public Board editBoard(Board board) {
        boardMapper.updateBoard(board);
        return boardMapper.selectBoardById(board.getId());
    }

    @Override
    public Page<Board> findBoardsByCategory(int pageNo, int pageSize, Category category) {
        PageHelper.startPage(pageNo, pageSize);
        return boardMapper.selectBoardByCategory(category);

    }


}
