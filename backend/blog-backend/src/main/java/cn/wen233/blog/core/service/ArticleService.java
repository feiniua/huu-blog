package cn.wen233.blog.core.service;

import cn.wen233.blog.common.dtos.PageInfo;
import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.article.ArticleVo;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

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
     * 分页查询
     * @param pageable
     * @return
     */
    PageInfo<ArticleVo> findAllPaging(Pageable pageable);


    /**
     * 查询该标签的所有文章
     * @param tagName
     * @return
     */
    List<ArticleVo> findAllByTag(String tagName);

    /**
     * 查询所有文章并通过time排序
     * @return
     */
    List<ArticleVo> findAllByTime();

    /**
     * 通过关键字查询
     * @param key
     * @return
     */
    List<Article> findByKey(String key);

    /**
     * 保存新文章
     * @param model
     * @param tagsId
     * @param file
     * @return
     * @throws Exception
     */
    Article insert(Article model, List<String> tagsId, MultipartFile file) throws Exception;

    /**
     * 对文章内容进行编辑
     * @param id
     * @param model
     * @param tagsId
     * @param file
     * @return
     * @throws Exception
     */
    Article edit(String id, Article model, List<String> tagsId, MultipartFile file) throws Exception;

    /**
     * 删除文章
     * @param id
     */
    void delete(String id);
}
