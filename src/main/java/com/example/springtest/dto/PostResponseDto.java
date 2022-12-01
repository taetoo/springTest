package com.example.springtest.dto;

import com.example.springtest.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;
    private Long id;
    private String title;
    private String content;
    private String author;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

}
