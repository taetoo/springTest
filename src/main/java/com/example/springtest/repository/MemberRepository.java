package com.example.springtest.repository;

import com.example.springtest.dto.MemberResponseDto;
import com.example.springtest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
