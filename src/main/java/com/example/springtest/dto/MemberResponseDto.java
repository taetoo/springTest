package com.example.springtest.dto;

import com.example.springtest.model.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;
    private String pw;
}
