package com.market.apple.domain.article.controller;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final MemberService memberService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList =  this.articleService.getList();
        model.addAttribute("articleList", articleList);

        return "article/article_list";
    }

    @GetMapping("article/create")
    public String create () {
        return "article/article_form";
    }

    @PostMapping("/article/create")
    public String create(@RequestParam("title") String title, @RequestParam("content") String content, Principal principal) throws Exception {
        Member member = memberService.findByUsername(principal.getName());

        this.articleService.create(title, content, member);
        return "redirect:/article/list";
    }

}
