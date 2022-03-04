package cn.jr.edu.service.impl;

import cn.jr.edu.entity.CourseDescription;
import cn.jr.edu.mapper.CourseDescriptionMapper;
import cn.jr.edu.service.ICourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements ICourseDescriptionService {

}
