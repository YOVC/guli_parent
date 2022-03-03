package cn.jr.edu.controller;


import cn.jr.R;
import cn.jr.edu.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author JR
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;

    //添加课程分类
    @RequestMapping("/addSubject")
    public R addSubject(MultipartFile file){
        subjectService.readSubject(file,subjectService);
        return R.ok();
    }

}

