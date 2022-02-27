package cn.jr.edu.service.impl;

import cn.jr.edu.entity.Teacher;
import cn.jr.edu.mapper.TeacherMapper;
import cn.jr.edu.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author JR
 * @since 2022-02-27
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
