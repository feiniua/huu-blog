package cn.wen233.blog.core.service.imps.auth;

import cn.wen233.blog.core.model.auth.Permission;
import cn.wen233.blog.core.repo.auth.PermissionRepository;
import cn.wen233.blog.core.service.PermissionService;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: huu
 * @date: 2020/4/8 11:54
 * @description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Permission insert(String name) {
        Permission model = new Permission();
        model.setName(name);
        return repository.save(model);
    }

    @Transactional(readOnly = true)
    @Override
    public Permission findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ModelNotFoundException("未找到指定id Permission"));
    }
}
