package cn.wen233.blog.core.repo;

import cn.wen233.blog.common.core.repo.BaseRepository;
import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: huu
 * @date: 2020/3/31 15:53
 * @description:
 */
@Repository
public interface TagRepository extends BaseRepository<Tag> {

    /**
     * 通过标签名寻找
     * @param name
     * @return
     */
    Tag findByName(String name);
}
