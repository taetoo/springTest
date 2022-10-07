package com.example.springtest.service;

import com.example.springtest.apiFormat.ApiResult;
import com.example.springtest.apiFormat.ApiUtils;
import com.example.springtest.dto.MemberResponseDto;
import com.example.springtest.model.Member;
import com.example.springtest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // 전체 회원 조회
    public ApiResult<List<MemberResponseDto>> getMembers() {
        List<Member> memberList = memberRepository.findAll();
        ArrayList<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        for(Member member : memberList) {
            MemberResponseDto memberResponseDto = new MemberResponseDto(member);
            memberResponseDtos.add(memberResponseDto);
        }
        return ApiUtils.success(memberResponseDtos);
    }

    public Member summitPost(MemberResponseDto responseDto) {
        Member member = new Member(responseDto);
        return memberRepository.save(member);
    }


//    public List<Member> getMembers() {
//        return memberRepository.findAll();
//    }

//    public ApiResult<Optional<Member>> getFindMembers(@PathVariable Long id) {
//        return ApiUtils.success(Optional.ofNullable(memberRepository.findById(id)
//                .orElseThrow(() -> new CustomException(EMPTY_CLIENT))));
//    }







}
