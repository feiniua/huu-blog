package cn.wen233.blog.core.model;

import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.tag.Tag;
import cn.wen233.blog.core.service.ArticleService;
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

    @Test
    void addTag() {
        Article article = service.findOne("0970d436-4cfa-42ad-ae3e-73622f597dd2");
        Tag tag = new Tag();
        tag.setName("前端");
        Tag tag1 = new Tag();
        tag1.setName("VUE");
        Set<Tag> tags = new HashSet<>();
        tags.add(tag);
        tags.add(tag1);
        article.setTags(tags);
        service.insert(article, null);
    }
}
