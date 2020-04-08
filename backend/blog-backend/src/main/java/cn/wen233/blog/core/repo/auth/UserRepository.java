package cn.wen233.blog.core.repo.auth;

import cn.wen233.blog.common.core.repo.BaseRepository;
import cn.wen233.blog.core.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: huu
 * @date: 2020/4/8 11:37
 * @description:
 */
@Repository
public interface UserRepository extends BaseRepository<User> {

    /**
     * 通过username查询User
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
}
