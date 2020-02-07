package com.zozo.book.springboot.domain.posts;

import com.zozo.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //update는 JPA에서 조회된 상태에서 변경된 값이 있으면 트랜잭션 끝난 시점에 자동 반영
    //객체지향 프로그래밍에서 객체의 상태 변경은 그 객체가 해야할 일이기 때문이며,
    //기존에 JPA가 없던 시절에는 객체가 본인의 값을 변경하는데도, 매번 DB에 update 쿼리를 일으켜야되서 이 원칙을 지키기 힘들었음
    //JPA가 이를 지원해준뒤로 DB를 사용하는 애플리케이션에서도 객체지향이 가능하게 된것
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
