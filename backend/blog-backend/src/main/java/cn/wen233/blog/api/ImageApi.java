package cn.wen233.blog.api;

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

    @PostMapping("")
    public RestInfo fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return RestInfo.fail("上传失败图片为空");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "->" + size);

        return RestInfo.success(QiNiuUtils.updateFile(file, fileName));
    }
}
