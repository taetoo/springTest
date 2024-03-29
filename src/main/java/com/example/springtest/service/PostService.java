package com.example.springtest.service;

import com.example.springtest.apiFormat.ApiResult;
import com.example.springtest.apiFormat.ApiUtils;
import com.example.springtest.dto.PostRequestDto;
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
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;



    // 전체 게시물 조회(stream)
    public ApiResult<List<PostResponseDto>> getMembers() {
        List<PostResponseDto> collect = postRepository.findAllByOrderByModifiedAtDesc().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
        return ApiUtils.success(collect);


    }

    // 전체 게시물 조회(for each 문)
//    public ApiResult<List<PostResponseDto>> getMembers() {
//        List<PostResponseDto> postResponseDtos = new ArrayList<>();
//        List<Post> postAll = postRepository.findAllByOrderByModifiedAtDesc();
//        for (Post post : postAll) {
//            PostResponseDto postResponseDto = new PostResponseDto(post);
//            postResponseDtos.add(postResponseDto);
//        }
//        return ApiUtils.success(postResponseDtos);
//    }

     // 특정 게시물 조회
    public ApiResult<PostResponseDto> getMember(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_DATA)
        );
        PostResponseDto responseDto = new PostResponseDto(post);
        return ApiUtils.success(responseDto);
    }

    // 특정 게시물 조회(DB 조회 메서드 별도 생성)
//    public ApiResult<PostResponseDto> getMember(Long id) {
//        Post post = checkMember(id);
//        PostResponseDto responseDto = new PostResponseDto(post);
//        return ApiUtils.success(responseDto);
//    }
//
//    private Post checkMember(Long id){
//       return postRepository.findById(id).orElseThrow(() -> {
//            throw new IllegalArgumentException("게시물 정보가 없습니다.");
//        });
//    }


    // 게시물 등록
    public ApiResult<PostResponseDto> summitPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        PostResponseDto responseDto = new PostResponseDto(post);
        return ApiUtils.success(responseDto);
    }


    // 게시물 수정
    @Transactional
    public ApiResult<?> updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_DATA)
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            post.updatePost(requestDto);
            PostResponseDto responseDto = new PostResponseDto(post);
            return ApiUtils.success(responseDto);
        } else {
            return ApiUtils.error("비밀번호를 확인해주세요.", 444);
        }


    }

    // 게시물 삭제
    @Transactional
    public ApiResult<?> deletePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.EMPTY_CLIENT)
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.deleteById(id);
            return ApiUtils.success("삭제완료!");
        } else {
            return ApiUtils.error("비밀번호를 확인해주세요.", 444);
        }
    }


}
