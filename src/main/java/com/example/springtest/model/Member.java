package com.example.springtest.model;

import com.example.springtest.dto.MemberResponseDto;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String pw;

    // 생성자
    public Member(MemberResponseDto responsetDto) {
        this.id = responsetDto.getId();
        this.name = responsetDto.getName();
        this.email = responsetDto.getEmail();
        this.pw = responsetDto.getPw();
    }

}
