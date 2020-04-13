package cn.wen233.blog.core.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: huu
 * @date: 2020/4/13 15:10
 * @description:
 */
public interface ImageService {

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    String uploadImage(MultipartFile file) throws Exception;
}
