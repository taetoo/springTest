package com.example.springtest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;
}
