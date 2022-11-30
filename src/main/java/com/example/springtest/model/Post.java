package com.example.springtest.model;

import com.example.springtest.dto.PostResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    // 생성자
    public Post(PostResponseDto responsetDto) {
        this.id = responsetDto.getId();
        this.title = responsetDto.getTitle();
        this.content = responsetDto.getContent();
        this.author = responsetDto.getAuthor();
        this.password = responsetDto.getPassword();
    }

    public void updatePost(PostResponseDto responseDto){
//        this.id = responseDto.getId();
        this.title = responseDto.getTitle();
        this.content = responseDto.getContent();
        this.author = responseDto.getAuthor();
        this.password = responseDto.getPassword();

    }

}
