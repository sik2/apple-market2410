package com.market.apple;

import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppleApplicationTests {


	@Autowired
	ArticleService articleService;

	@Autowired
	MemberService memberService;

	@Test
	void join() {
		Member member = memberService.join("test", "1234", "tester", "test@test.com");

	}

	@Test
	void contextLoads() {
		Member m = new Member();

		for (int i = 0; i <= 30; i++) {
			articleService.create("제목" + i, "내용" + i, m);
		}

	}

}
