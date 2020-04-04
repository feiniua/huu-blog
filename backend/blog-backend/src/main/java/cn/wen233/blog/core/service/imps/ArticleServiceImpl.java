package cn.wen233.blog.core.service.imps;

import cn.wen233.blog.common.dtos.PageInfo;
import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.article.ArticleVo;
import cn.wen233.blog.core.model.tag.Tag;
import cn.wen233.blog.core.repo.ArticleRepository;
import cn.wen233.blog.core.repo.TagRepository;
import cn.wen233.blog.core.service.ArticleService;
import cn.wen233.blog.core.service.TagService;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/3/29 15:04
 * @description:
 */
@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;

    private final TagService tagService;


    @Transactional(readOnly = true)
    @Override
    public Article findOne(String id) {
        return repository.findById(id).orElseThrow(() -> new ModelNotFoundException("未找到指定id的Article"));
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo<ArticleVo> findAll(Pageable pageable) {
        Page<Article> page = repository.findAll(pageable);
        return PageInfo.of(ArticleVo.mapForm(page.getContent()), page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Article insert(Article model, List<String> tagsId) {
        Set<Tag> tags = byIdToTag(tagsId);

        Article entity = new Article();
        BeanUtils.copyProperties(model, entity);
        if (tags != null && tags.size() != 0) {
            entity.setTags(tags);
        }
        return repository.save(entity);
    }

    /**
     * 将Tag id数组转为Set<Tag>
     * @param tagsId
     * @return
     */
    private Set<Tag> byIdToTag(List<String> tagsId) {
        if (tagsId == null) {
            return null;
        }
        Set<Tag> tags = new HashSet<>();
        for (String s : tagsId) {
            Tag entity = tagService.findById(s);
            tags.add(entity);
        }
        return tags;
    }
}
