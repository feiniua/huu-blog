package cn.wen233.blog.core.repo.auth;

import cn.wen233.blog.common.core.repo.BaseRepository;
import cn.wen233.blog.core.model.auth.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: huu
 * @date: 2020/4/8 11:38
 * @description:
 */
@Repository
public interface RoleRepository extends BaseRepository<Role> {

    /**
     * 通过name查询Role
     * @param name
     * @return
     */
    Optional<Role> findByName(String name);
}
