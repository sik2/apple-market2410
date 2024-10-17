package com.market.apple.domain.article.service;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.repository.ArticleRepository;
import com.market.apple.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Value("${custom.fileDirPath}")
    private String fileDirPath;

    public void create(String title, String content, Member member, MultipartFile thumbnail) {

        String thumbnailRelPath = "article/" + UUID.randomUUID().toString() + ".jpg";

        File thumnailFile = new File(fileDirPath + "/" +thumbnailRelPath);

        try {
            thumbnail.transferTo(thumnailFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        Article article = new Article();
//        article.setTitle(title);
//        article.setContent(content);
        Article article = Article.builder()
                        .title(title)
                        .content(content)
                        .author(member)
                        .thumbnailImg(thumbnailRelPath)
                        .build();

        articleRepository.save(article);
    }

    public void create(String title, String content, Member member) {

        Article article = Article.builder()
                .title(title)
                .content(content)
                .author(member)
                .build();

        articleRepository.save(article);
    }

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }
}
