package com.example.springtest.controller;

import com.example.springtest.MemberRepository;
import com.example.springtest.dto.MemberRequestDto;
import com.example.springtest.model.Member;
import com.example.springtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 회원 전체 조회
    @GetMapping("/api/member")
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    // 특정 회원 조회
    @GetMapping("/api/member/{id}")
    public Optional<Member> getMembers(@PathVariable Long id) {
       return memberRepository.findById(id);
    }

}
