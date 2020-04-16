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
    public RestInfo insert(@RequestBody Tag model) {
        return RestInfo.success(service.insert(model));
    }

    @PutMapping("/{id}")
    public RestInfo edit(@PathVariable String id, @RequestBody Tag model) {
        return RestInfo.success(service.edit(id, model));
    }

    @DeleteMapping("/{id}")
    public RestInfo delete(@PathVariable String id) {
        service.delete(id);
        return RestInfo.success();
    }

}
