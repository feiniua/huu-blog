package cn.wen233.blog.core.service.imps;

import cn.wen233.blog.common.dtos.PageInfo;
import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.model.article.ArticleVo;
import cn.wen233.blog.core.model.article.QArticle;
import cn.wen233.blog.core.model.tag.Tag;
import cn.wen233.blog.core.repo.ArticleRepository;
import cn.wen233.blog.core.service.ArticleService;
import cn.wen233.blog.core.service.ImageService;
import cn.wen233.blog.core.service.TagService;
import cn.wen233.blog.infrustructure.exception.ModelNotFoundException;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: huu
 * @date: 2020/3/29 15:04
 * @description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;

    private final TagService tagService;

    private final ImageService imageService;

    private final EntityManager entityManager;

    @Autowired
    public ArticleServiceImpl(ArticleRepository repository, TagService tagService, ImageService imageService, EntityManager entityManager) {
        this.repository = repository;
        this.tagService = tagService;
        this.imageService = imageService;
        this.entityManager = entityManager;
    }

    private JPAQueryFactory jpaQueryFactory;

    /**
     * 因为factory 依赖于 entityManager
     */
    @PostConstruct
    public void initFactory() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }


    /**
     * 查询单篇文章
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Article findOne(String id) {
        return repository.findById(id).orElseThrow(() -> new ModelNotFoundException("未找到指定id的Article"));
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public PageInfo<ArticleVo> findAllPaging(Pageable pageable) {
        Page<Article> page = repository.findAll(pageable);
        return PageInfo.of(ArticleVo.mapForm(page.getContent()), page);
    }

    /**
     * 通过tag查询所有文章
     * @param tagName
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ArticleVo> findAllByTag(String tagName) {
        QArticle qArticle = QArticle.article;
        JPAQuery<Article> query = jpaQueryFactory
                .select(qArticle)
                .from(qArticle)
                .where(qArticle.tags.any().name.eq(tagName))
                .orderBy(QArticle.article.createAt.desc());
        List<Article> articles = query.fetch();
        return ArticleVo.mapForm(articles);
    }

    /**
     * 通过时间查询所有文章
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<ArticleVo> findAllByTime() {
        QArticle qArticle = QArticle.article;
        JPAQuery<Article> query = jpaQueryFactory
                .select(qArticle)
                .from(qArticle)
                .orderBy(QArticle.article.createAt.desc());
        List<Article> articles = query.fetch();
        return ArticleVo.mapForm(articles);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Article> findByKey(String key) {
        QArticle qArticle = QArticle.article;
        JPAQuery<Article> query = jpaQueryFactory
                .select(qArticle)
                .from(qArticle)
                .where(qArticle.title.like("%" + key+ "%"))
                .orderBy(QArticle.article.createAt.desc());
        List<Article> articles = query.fetch();
        return articles;
    }


    /**
     * 新建文章
     * @param model
     * @param tagsId
     * @param file
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Article insert(Article model, List<String> tagsId, MultipartFile file) throws Exception {

        // 上传图片
        String imageAddress = imageService.uploadImage(file);

        Set<Tag> tags = byIdToTag(tagsId);

        Article entity = new Article();
        BeanUtils.copyProperties(model, entity);
        if (tags != null && tags.size() != 0) {
            entity.setTags(tags);
        }
        entity.setImageAddress(imageAddress);
        return repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Article edit(String id, Article model, List<String> tagsId, MultipartFile file) throws Exception {
        Set<Tag> tagModels = byIdToTag(tagsId);

        Article entity = findOne(id);
        Set<Tag> tagEntitys = entity.getTags();
        // 基础字段赋值
        entity.setTitle(model.getTitle());
        entity.setContent(model.getContent());
        // 在交集中添加model中有的
        tagSet(tagModels, tagEntitys);
        if (file != null) {
            String imageAddress = imageService.uploadImage(file);
            entity.setImageAddress(imageAddress);
        }
        return entity;
    }

    @Override
    public void delete(String id) {
        Article entity = this.findOne(id);
        repository.delete(entity);
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

    /**
     * 先取model和entity的交集，然后去出model没有的
     * @param tagModels
     * @param tagEntitys
     */
    private void tagSet(Set<Tag> tagModels, Set<Tag> tagEntitys) {
        // 先将model中有的添加
        for (Tag tag : tagModels) {
            if (tagEntitys.contains(tag)) {
                continue;
            }
            tagEntitys.add(tag);
        }
        // 取出entity中有 model中没有的
        tagEntitys.removeIf(tag -> !tagModels.contains(tag));
    }
}
