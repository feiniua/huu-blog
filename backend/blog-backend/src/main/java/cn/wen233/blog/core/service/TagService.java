package cn.wen233.blog.core.service;

import cn.wen233.blog.core.model.tag.Tag;

import java.util.List;

/**
 * @author: huu
 * @date: 2020/3/31 15:55
 * @description:
 */
public interface TagService {

    Tag findById(String id);

    List<Tag> findAll();

    Tag insert(Tag model);
}
