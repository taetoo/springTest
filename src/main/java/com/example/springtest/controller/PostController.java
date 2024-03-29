package com.example.springtest.controller;

import com.example.springtest.apiFormat.ApiResult;
import com.example.springtest.dto.PostRequestDto;
import com.example.springtest.dto.PostResponseDto;
import com.example.springtest.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
@Api(value = "Member entity api", tags = {"Post"})
public class PostController {

    private final PostService postService;

    // 게시물 전체 조회
    @ApiOperation(value = "전체 게시물 조회", notes = "전체 게시물을 조회하기 위한 api 입니다.")
    @GetMapping("/posts")
    public ApiResult<List<PostResponseDto>> getMembers()  {
        return postService.getMembers();

    }
    // 특정 게시물 조회
    @ApiOperation(value = "특정 게시물 조회", notes = "특정 게시물을 조회하기 위한 api 입니다.")
    @GetMapping("/post/{id}")
    public ApiResult<PostResponseDto> getFindMembers(@PathVariable Long id) {
//        return ApiUtils.success(postRepository.findById(id));
        return postService.getMember(id);
    }

    // 게시물 생성
    @ApiOperation(value = "게시물 생성", notes = "게시물을 생성하는 api 입니다.")
    @PostMapping("/post")
    public ApiResult<PostResponseDto> summitPost(@RequestBody PostRequestDto requestDto){
        return postService.summitPost(requestDto);
    }

    // 게시물 수정
    @ApiOperation(value = "게시물 수정", notes = "게시물을 수정하는 api 입니다.")
    @PutMapping("/post/{id}")
    public ApiResult<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(id, requestDto);
    }

    // 게시물 삭제
    @ApiOperation(value = "게시물 삭제", notes = "게시물을 수정하는 api 입니다.")
    @DeleteMapping("/post/{id}")
    public ApiResult<?> deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.deletePost(id, requestDto);
    }



}
