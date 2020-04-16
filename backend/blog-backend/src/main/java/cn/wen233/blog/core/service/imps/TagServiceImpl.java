package cn.wen233.blog.core.service.imps;

import cn.wen233.blog.core.model.tag.Tag;
import cn.wen233.blog.core.repo.TagRepository;
import cn.wen233.blog.core.service.TagService;
import cn.wen233.blog.infrustructure.exception.CheckException;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/3/31 15:55
 * @description:
 */
@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Tag findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ModelNotFoundException("未找到指定id的Tag"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tag> findAll() {
        return repository.findAll();
    }

    /**
     * 添加标签时判断库中有没有同名标签
     * @param model
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Tag insert(Tag model) {
        checkTagName(model.getName());
        Tag entity = repository.findByName(model.getName());
        if (entity != null) {
            return entity;
        }
        entity = new Tag();
        BeanUtils.copyProperties(model, entity);
        return repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Tag edit(String id, Tag model) {
        checkTagName(model.getName());
        Tag entity = findById(id);
        entity.setName(model.getName());
        return entity;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String id) {
        Tag entity = findById(id);
        repository.delete(entity);
    }

    private void checkTagName(String tagName) {
        List<Tag> entitys = repository.findAll();
        for (Tag entity : entitys) {
            if (entity.getName().equals(tagName)) {
                throw new CheckException("tag名称不能重复");
            }
        }
    }

}
