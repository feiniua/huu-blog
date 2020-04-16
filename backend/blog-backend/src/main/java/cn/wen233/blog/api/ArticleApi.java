package cn.wen233.blog.api;

import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.service.ArticleService;
import cn.wen233.blog.infrustructure.utils.qiniu.QiNiuUtils;
import cn.wen233.blog.common.restful.RestInfo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: huu
 * @date: 2020/3/29 15:20
 * @description:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleApi {

    private final ArticleService service;

    @GetMapping("/{id}")
    public RestInfo findById(@PathVariable("id") String id) {
        return RestInfo.success(service.findOne(id));
    }

    /**
     * 获取所有文章并分页，设置默认pageSize = 8
     * @param pageable
     * @return
     */
    @GetMapping("/all")
    public RestInfo findAllPaging(@PageableDefault(value = 8, sort = {"createAt"}, direction = Sort.Direction.DESC)
                                        Pageable pageable, Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 0;
        }
        Pageable pageable1 = PageRequest.of(pageNumber, pageable.getPageSize(), pageable.getSort());
        return RestInfo.success(service.findAllPaging(pageable1));
    }

    /**
     * 通过tag 查询文章
     * @param tagName
     * @return
     */
    @GetMapping("/byTagName")
    public RestInfo findAllByTag(@RequestParam String tagName) {
        return RestInfo.success(service.findAllByTag(tagName));
    }

    @GetMapping("/byTime")
    public RestInfo findAllByTime() {
        return RestInfo.success(service.findAllByTime());
    }

    @GetMapping("/byKey")
    public RestInfo findByKey(@RequestParam(name = "key") String model) {
        System.out.println(model);
        return RestInfo.success(service.findByKey(model));
    }

    /**
     * 采用表单提交的话需要 @RequestParam跟前端标签的name一致
     * @param title
     * @param content
     * @param file
     * @param tagsId
     * @return
     * @throws Exception
     */
    @PostMapping("")
    public RestInfo save(@RequestParam String title, @RequestParam String content,
                         @RequestParam(name = "file")MultipartFile file,
                         @RequestParam @Nullable List<String> tagsId) throws Exception {
        Article model = new Article();
        model.setTitle(title);
        model.setContent(content);
        return RestInfo.success(service.insert(model, tagsId, file));
    }

    @PutMapping("/{id}")
    public RestInfo editArticle(@PathVariable("id") String id,
                                @RequestParam String title, @RequestParam String content,
                                @RequestParam(name = "file") @Nullable MultipartFile file,
                                @RequestParam @Nullable List<String> tagsId) throws Exception {
        Article model = new Article();
        model.setTitle(title);
        model.setContent(content);
        return RestInfo.success(service.edit(id, model, tagsId, file));
    }

    @DeleteMapping("/{id}")
    public RestInfo deleteArticle(@PathVariable("id") String id) {
        service.delete(id);
        return RestInfo.success();
    }


//    @PostMapping("/ajax")
//    public RestInfo save(@RequestBody Article model) {
//        System.out.println(model);
//        return RestInfo.success(service.insert(model));
//    }
}
