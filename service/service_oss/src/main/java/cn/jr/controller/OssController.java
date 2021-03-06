package cn.jr.controller;

import cn.jr.R;
import cn.jr.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    OssService ossService;

    @PostMapping("/uploadOssFile")
    public R uploadOssFile(MultipartFile file){
        String url=ossService.uploadFile(file);
        return R.ok().data("url",url);
    }
}
