package com.example.springtest.controller;

import com.example.springtest.apiFormat.ApiResult;
import com.example.springtest.apiFormat.ApiUtils;
import com.example.springtest.model.Member;
import com.example.springtest.repository.MemberRepository;
import com.example.springtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;


    // 회원 전체 조회
    @RequestMapping("/member")
    public ApiResult<List<Member>> getMembers()  {
        return memberService.getMembers();

    }

    // 특정 회원 조회
    @RequestMapping("/member/{id}")
    public ApiResult<Optional<Member>> getFindMembers(@PathVariable Long id) {
        return ApiUtils.success(memberRepository.findById(id));
    }

}

// 커스텀 Exception


//    @GetMapping("/api/member")
//    public String members(Member member)  {
//        if (member.getId() == null) {
//            throw new CustomException(EMPTY_CLIENT);
//        }
//        return memberService.getMembers().toString();
//
//    }