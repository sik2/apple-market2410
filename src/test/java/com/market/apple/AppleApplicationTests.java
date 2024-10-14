package com.market.apple;

import com.market.apple.domain.article.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppleApplicationTests {

	@Autowired
	ArticleService articleService;

	@Test
	void contextLoads() {
		for (int i = 0; i <= 30; i++) {
			articleService.create("제목" + i, "내용" + i);
		}

	}

}
