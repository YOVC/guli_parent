package cn.jr.edu.service.impl;

import cn.jr.ExceptionHandler.GuliException;
import cn.jr.edu.entity.Course;
import cn.jr.edu.entity.CourseDescription;
import cn.jr.edu.entity.vo.CourseInfoVo;
import cn.jr.edu.mapper.CourseMapper;
import cn.jr.edu.service.ICourseDescriptionService;
import cn.jr.edu.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private ICourseDescriptionService courseDescriptionService;
    @Override
    public void saveCourseInfo(CourseInfoVo courseInfoVo) {
        //保存课程基本信息
        Course course=new Course();
        BeanUtils.copyProperties(courseInfoVo,course);
        boolean insert=this.save(course);
        if(!insert){
            throw new GuliException(20001,"保存课程基本信息失败");
        }
        //获取保存课程之后的id
        String cid=course.getId();
        //保存课程描述
        CourseDescription courseDescription=new CourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(cid);
        boolean flag=courseDescriptionService.save(courseDescription);
        if(!flag){
            throw new GuliException(20001,"保存课程描述失败");
        }
    }
}
