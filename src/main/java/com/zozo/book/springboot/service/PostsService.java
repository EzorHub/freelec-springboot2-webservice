package com.zozo.book.springboot.service;

import com.zozo.book.springboot.domain.posts.Posts;
import com.zozo.book.springboot.domain.posts.PostsRepository;
import com.zozo.book.springboot.web.dto.PostsListResponseDto;
import com.zozo.book.springboot.web.dto.PostsResponseDto;
import com.zozo.book.springboot.web.dto.PostsSaveRequestDto;
import com.zozo.book.springboot.web.dto.PostsUpdateRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestsDto requestsDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestsDto.getTitle(), requestsDto.getContent());
        return id;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
