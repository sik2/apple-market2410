package com.market.apple.domain.article.entity;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article extends BaseEntity {
    private String title;
    private String content;
    @ManyToOne
    private Member author;
    private String thumbnailImg;
}
