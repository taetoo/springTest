package com.example.springtest.service;

import com.example.springtest.apiFormat.ApiResult;
import com.example.springtest.apiFormat.ApiUtils;
import com.example.springtest.dto.PostResponseDto;
import com.example.springtest.exception.CustomException;
import com.example.springtest.exception.ErrorCode;
import com.example.springtest.model.Post;
import com.example.springtest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // 전체 게시물 조회
    public ApiResult<List<PostResponseDto>> getMembers() {
        List<Post> postAll = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(Post post : postAll){
            PostResponseDto postResponseDto = new PostResponseDto(post);
            postResponseDtos.add(postResponseDto);
        }
        return ApiUtils.success(postResponseDtos);
    }

    // 특정 게시물 조회
    public ApiResult<PostResponseDto> getMember(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_DATA)
        );
        PostResponseDto responseDto = new PostResponseDto(post);
        return ApiUtils.success(responseDto);
    }

    // 게시물 등록
    public ApiResult<PostResponseDto> summitPost(PostResponseDto responseDto) {
        Post post = new Post(responseDto);
        postRepository.save(post);
        return ApiUtils.success(responseDto);
    }


    // 게시물 수정
    @Transactional
    public ApiResult<PostResponseDto> updatePost(Long id, PostResponseDto dto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_DATA)
        );
        post.updatePost(dto);
        PostResponseDto responseDto = new PostResponseDto(post);
        return ApiUtils.success(responseDto);

    }

    // 게시물 삭제
    @Transactional
    public ApiResult<?> deletePost(Long id, PostResponseDto responseDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.EMPTY_CLIENT)
        );
        if(post.getPassword().equals(responseDto.getPassword())){
            postRepository.deleteById(id);
           return ApiUtils.success("success");
        } else{
            return ApiUtils.error("비밀번호를 확인해주세요.",444);
        }
    }


}
