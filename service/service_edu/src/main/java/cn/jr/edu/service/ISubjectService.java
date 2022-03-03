package cn.jr.edu.service;

import cn.jr.edu.entity.Subject;
import cn.jr.edu.entity.subject.OneSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author JR
 * @since 2022-03-02
 */
public interface ISubjectService extends IService<Subject> {
    /**
     * 添加课程分类
     * @param file 读取上传到xlsx文件
     * @param subjectService 传入service，为了在监听器中通过构造器注入
     */
    void readSubject(MultipartFile file,ISubjectService subjectService);

    /**
     * 课程分类列表（通过树形展示）
     * @return 返回所有分装了二级分类的一级分类
     */
    List<OneSubject> getAllOneTwoSubject();

}
