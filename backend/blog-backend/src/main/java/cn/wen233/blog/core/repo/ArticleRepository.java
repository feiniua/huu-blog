package cn.wen233.blog.core.repo;

import cn.wen233.blog.core.model.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: huu
 * @date: 2020/3/29 15:02
 * @description:
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, String>, QuerydslPredicateExecutor<Article> {
}
