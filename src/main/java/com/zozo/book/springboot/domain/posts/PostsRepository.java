package com.zozo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC ") //posts가 아니라 Posts! 대소문자구분으로 오류났었음
    List<Posts> findAllDesc();
}
