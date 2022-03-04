package cn.jr.edu.controller;


import cn.jr.R;
import cn.jr.edu.entity.vo.CourseInfoVo;
import cn.jr.edu.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private ICourseService courseService;


    /**新增加课程*/
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.saveCourseInfo(courseInfoVo);
        return R.ok();
    }
}

