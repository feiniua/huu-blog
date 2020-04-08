package cn.wen233.blog.common.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author: huu
 * @date: 2020/4/8 11:39
 * @description:
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, String>, QuerydslPredicateExecutor<T> {
}
