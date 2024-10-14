package com.no1.jpashopping.board.service;

import com.no1.jpashopping.board.domain.Board;
import org.springframework.data.domain.Page;

public interface BoardService {
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);
    Board getBoard(Board board);
    Page<Board> getBoardList(Board board);
}
