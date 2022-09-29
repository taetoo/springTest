package com.example.springtest.model;

import com.example.springtest.dto.MemberRequestDto;
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
//    public Member(MemberRequestDto requestDto) {
//        this.name = requestDto.getName();
//        this.email = requestDto.getEmail();
//        this.pw = requestDto.getPw();
//    }

}
