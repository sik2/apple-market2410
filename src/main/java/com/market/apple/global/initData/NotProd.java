package com.market.apple.global.initData;

import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "test"})
public class NotProd {

    @Bean
    public CommandLineRunner init(MemberService memberService, ArticleService articleService) {
        return args -> {
            Member admin = memberService.join("admin", "1234", "admin", "admin@admin.com");
            Member member1 =  memberService.join("member1", "1234", "member1", "member1@member1.com");
            Member member2 = memberService.join("member2", "1234", "member2", "member2@member2.com");

            articleService.create("제목1",  "내용1", admin);
            articleService.create("제목2",  "내용2", member1);
            articleService.create("제목3",  "내용3", member2);

        };
    }

}
