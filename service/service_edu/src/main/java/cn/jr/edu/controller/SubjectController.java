package cn.jr.edu.controller;


import cn.jr.R;
import cn.jr.edu.entity.subject.OneSubject;
import cn.jr.edu.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    /**添加课程分类*/
    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file){
        subjectService.readSubject(file,subjectService);
        return R.ok();
    }

    /**课程分类列表（树形）*/
    @GetMapping("/getAllSubject")
    public R getAllSubject(){
        List<OneSubject> oneSubjects= subjectService.getAllOneTwoSubject();
        return R.ok().data("list",oneSubjects);
    }

}

