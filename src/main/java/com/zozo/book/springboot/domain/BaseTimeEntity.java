package com.zozo.book.springboot.domain;

/*
* 2020.02.07
* JPA Auditing으로 생성시간/수정시간 자동화
* BaseTimeEntity 클래스는 모든 엔티티의 상위 클래스가 되어
* 엔티티들의 생성시간/수정시간을 자동으로 관리하는 역할임
* [책]스프링부트와 AWS로 혼자 구현하는 웹서비스
* */

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
