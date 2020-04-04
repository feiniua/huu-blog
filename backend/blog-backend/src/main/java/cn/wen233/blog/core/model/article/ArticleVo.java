package cn.wen233.blog.core.model.article;

import cn.wen233.blog.core.model.tag.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/3/31 18:05
 * @description:
 */
@Data
public class ArticleVo {

    private final static int MAX_CONTENT = 200;

    private String id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private Set<Tag> tags;
    private String imageAddress;

    public ArticleVo(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.createAt = article.getCreateAt();
        this.tags = article.getTags();
        this.imageAddress = article.getImageAddress();

        String body = filter(article.getContent());
        if (body.length() > MAX_CONTENT) {
            body = body.substring(0, MAX_CONTENT).concat("...");
        }
        this.content = body;
    }

    /**
     * 将List Article 转为 List ArticleVO
     * @param entities
     * @return
     */
    public static List<ArticleVo> mapForm(List<Article> entities) {
        List<ArticleVo> articleVos = new LinkedList<>();
        for (Article article : entities) {
            articleVos.add(new ArticleVo(article));
        }
        return articleVos;
    }


    /**
     * 过滤特殊符号
     * @param body
     * @return
     */
    private String filter(String body) {
        return body;
    }
}
