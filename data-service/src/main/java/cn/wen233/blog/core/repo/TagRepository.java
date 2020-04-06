package cn.wen233.blog.core.repo;

import cn.wen233.blog.core.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: huu
 * @date: 2020/3/31 15:53
 * @description:
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    /**
     * 通过标签名寻找
     * @param name
     * @return
     */
    Tag findByName(String name);
}
