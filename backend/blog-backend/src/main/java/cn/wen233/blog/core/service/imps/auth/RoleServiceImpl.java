package cn.wen233.blog.core.service.imps.auth;

import cn.wen233.blog.core.model.auth.Permission;
import cn.wen233.blog.core.model.auth.Role;
import cn.wen233.blog.core.repo.auth.RoleRepository;
import cn.wen233.blog.core.service.PermissionService;
import cn.wen233.blog.core.service.RoleService;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/4/8 11:47
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    private final PermissionService permissionService;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, PermissionService permissionService) {
        this.repository = repository;
        this.permissionService = permissionService;
    }

    @Override
    public Role insert(String name, String... permissionNames) {
        Role model = new Role();
        model.setName(name);
        Set<Permission> permissions = new HashSet<>();
        for (String permissionName : permissionNames) {
            Permission entity = permissionService.findByName(permissionName);
            permissions.add(entity);
        }
        model.setPermissions(permissions);
        return repository.save(model);
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ModelNotFoundException("未找到指定id Role"));
    }

}
