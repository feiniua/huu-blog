package cn.wen233.blog.api;

import cn.wen233.blog.core.service.ImageService;
import cn.wen233.blog.infrustructure.utils.qiniu.QiNiuUtils;
import cn.wen233.blog.common.restful.RestInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author: huu
 * @date: 2020/3/31 12:20
 * @description:
 */
@RestController
@RequestMapping("/image")
public class ImageApi {

    private final ImageService imageService;

    public ImageApi(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("")
    public RestInfo fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        return RestInfo.success(imageService.uploadImage(file));
    }
}
