package cn.wen233.blog.core.service;

import cn.wen233.blog.common.dtos.PageInfo;
import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.article.ArticleVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: huu
 * @date: 2020/3/29 15:03
 * @description:
 */
public interface ArticleService {

    /**
     * 通过指定id寻找Article
     * @param id
     * @return
     */
    Article findOne(String id);


    /**
     * 首页分页数据
     * @param pageable
     * @return
     */
    PageInfo<ArticleVo> findAll(Pageable pageable);


    List<ArticleVo> findAllByTag(String tagName);

    /**
     * 保存新文章
     * @param model
     * @param tagsId
     * @return
     */
    Article insert(Article model, List<String> tagsId);
}
