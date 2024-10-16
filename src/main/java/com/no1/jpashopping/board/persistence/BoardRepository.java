package com.no1.jpashopping.board.persistence;

import com.no1.jpashopping.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {

    @Query("SELECT b FROM Board b")
    Page<Board> getBoardList(Pageable pageable);
}
