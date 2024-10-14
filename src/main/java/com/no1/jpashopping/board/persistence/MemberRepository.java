package com.no1.jpashopping.board.persistence;

import com.no1.jpashopping.board.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
