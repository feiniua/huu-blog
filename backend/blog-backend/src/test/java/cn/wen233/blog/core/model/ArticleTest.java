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
        Article article = service.findOne("254c0f2c-27ec-4a1c-89dd-eb8c2b3b7bc8");
        Tag tag = new Tag();
        tag.setName("首页标签测试1");
        Tag tag1 = new Tag();
        tag1.setName("函数测试1");
        Set<Tag> tags = new HashSet<>();
        tags.add(tag);
        tags.add(tag1);
        article.setTags(tags);
        service.insert(article, null);
    }

    @Test
    void delTag() {
        Tag tag = tagRepository.findById("da4b3c29-2802-4623-9cf2-54e820badbf2").orElseThrow(() -> new ModelNotFoundException("未找到"));
        tagRepository.delete(tag);

    }
}
