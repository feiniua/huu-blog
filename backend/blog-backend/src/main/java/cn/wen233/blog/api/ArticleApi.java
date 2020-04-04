package cn.wen233.blog.api;

import cn.wen233.blog.core.model.article.Article;
import cn.wen233.blog.core.service.ArticleService;
import cn.wen233.blog.infrustructure.utils.qiniu.QiNiuUtils;
import cn.wen233.blog.common.restful.RestInfo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/all")
    public RestInfo findAll(Pageable pageable) {
        return RestInfo.success(service.findAll(pageable));
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
    public RestInfo save(@RequestParam @Validated String title, @RequestParam String content,
                         @RequestParam(name = "fileName")MultipartFile file,
                         @RequestParam @Nullable List<String> tagsId) throws Exception {
        if (file.isEmpty()) {
            return RestInfo.fail("上传失败图片为空");
        }
        String fileName = file.getOriginalFilename();
        String imageAddress = QiNiuUtils.updateFile(file, fileName);

        Article model = new Article();
        model.setTitle(title);
        model.setContent(content);
        model.setImageAddress(imageAddress);
        return RestInfo.success(service.insert(model, tagsId));
    }

//    @PostMapping("/ajax")
//    public RestInfo save(@RequestBody Article model) {
//        System.out.println(model);
//        return RestInfo.success(service.insert(model));
//    }
}
