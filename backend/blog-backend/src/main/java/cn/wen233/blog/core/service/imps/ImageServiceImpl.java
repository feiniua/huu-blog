package cn.wen233.blog.core.service.imps;

import cn.wen233.blog.common.restful.RestInfo;
import cn.wen233.blog.core.service.ImageService;
import cn.wen233.blog.infrustructure.exception.UploadException;
import cn.wen233.blog.infrustructure.utils.qiniu.QiNiuUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: huu
 * @date: 2020/4/13 15:10
 * @description:
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String uploadImage(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new UploadException("图片不能为空");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "->" + size);
        return QiNiuUtils.updateFile(file, fileName);
    }
}
