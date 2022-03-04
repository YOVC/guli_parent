package cn.jr.edu.service;

import cn.jr.edu.entity.Course;
import cn.jr.edu.entity.vo.CourseInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
public interface ICourseService extends IService<Course> {

    /**
     * 新增课程
     * @param courseInfoVo 课程和课程描述的分装类
     */
    void saveCourseInfo(CourseInfoVo courseInfoVo);
}
