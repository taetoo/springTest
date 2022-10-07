package com.example.springtest.controller;

import com.example.springtest.apiFormat.ApiResult;
import com.example.springtest.apiFormat.ApiUtils;
import com.example.springtest.dto.MemberResponseDto;
import com.example.springtest.model.Member;
import com.example.springtest.repository.MemberRepository;
import com.example.springtest.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@Api(value = "Member entity api", tags = {"Member"})
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 회원 전체 조회
    @ApiOperation(value = "회원 전체 조회", notes = "전체 회원을 조회하기 위한 api 입니다.")
    @GetMapping("/api/member")
    public ApiResult<List<MemberResponseDto>> getMembers()  {
        return memberService.getMembers();

    }

    // 특정 회원 조회
    @ApiOperation(value = "특정 회원 조회", notes = "특정 회원을 조회하기 위한 api 입니다.")
    @GetMapping("/api/member/{id}")
    public ApiResult<Optional<Member>> getFindMembers(@PathVariable Long id) {
        return ApiUtils.success(memberRepository.findById(id));
    }

    // 게시물 생성
    @ApiOperation(value = "게시물 생성", notes = "게시물을 생성하는 api 입니다.")
    @PostMapping("/api/members")
    public ApiResult<Member> summitPost(@RequestBody MemberResponseDto responseDto){
        return ApiUtils.success(memberService.summitPost(responseDto));
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