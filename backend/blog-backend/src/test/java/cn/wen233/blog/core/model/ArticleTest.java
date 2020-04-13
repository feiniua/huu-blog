package cn.wen233.blog.core.model;

import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.tag.Tag;
import cn.wen233.blog.core.repo.TagRepository;
import cn.wen233.blog.core.service.ArticleService;
import cn.wen233.blog.core.service.TagService;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/3/30 16:16
 * @description:
 */
@SpringBootTest
public class ArticleTest {

    @Autowired
    private ArticleService service;

    @Autowired
    private TagRepository tagRepository;

    @Test
    void addTag() {

    }

    @Test
    void delTag() {
        Tag tag = tagRepository.findById("da4b3c29-2802-4623-9cf2-54e820badbf2").orElseThrow(() -> new ModelNotFoundException("未找到"));
        tagRepository.delete(tag);

    }
}
