package cn.wen233.blog.api;

import cn.wen233.blog.core.model.tag.Tag;
import cn.wen233.blog.core.service.TagService;
import cn.wen233.blog.common.restful.RestInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author: huu
 * @date: 2020/3/31 15:58
 * @description:
 */
@RestController
@RequestMapping("/tag")
@AllArgsConstructor
public class TagApi {

    private final TagService service;

    @GetMapping("/all")
    public RestInfo findAll() {
        return RestInfo.success(service.findAll());
    }

    @PostMapping("")
    public RestInfo insert(@RequestParam String tagName) {
        Tag model = new Tag();
        model.setName(tagName);
        return RestInfo.success(service.insert(model));
    }

}
