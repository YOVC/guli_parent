package cn.jr.edu.controller;


import cn.jr.R;
import cn.jr.edu.entity.Chapter;
import cn.jr.edu.entity.chapter.ChapterVo;
import cn.jr.edu.service.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private IChapterService chapterService;

    @GetMapping("/getChpter/{courseId}")
    public R getChapter(@PathVariable("courseId") String courseId){
        List<ChapterVo> chapterVos=chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("chapter",chapterVos);
    }

}

