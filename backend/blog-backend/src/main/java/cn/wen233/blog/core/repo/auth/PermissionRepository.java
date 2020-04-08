package cn.wen233.blog.core.repo.auth;

import cn.wen233.blog.common.core.repo.BaseRepository;
import cn.wen233.blog.core.model.auth.Permission;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: huu
 * @date: 2020/4/8 11:43
 * @description:
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission> {
    /**
     * 通过name查询Permission
     * @param name
     * @return
     */
    Optional<Permission> findByName(String name);
}
