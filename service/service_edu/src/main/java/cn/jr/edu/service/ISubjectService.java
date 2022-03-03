package cn.jr.edu.service;

import cn.jr.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author JR
 * @since 2022-03-02
 */
public interface ISubjectService extends IService<Subject> {
    public void readSubject(MultipartFile file,ISubjectService subjectService);
}
