package cn.jr.edu.service.impl;

import cn.jr.ExceptionHandler.GuliException;
import cn.jr.edu.entity.Subject;
import cn.jr.edu.entity.excel.ExcelSubjectData;
import cn.jr.edu.listen.ExcelSubjectListen;
import cn.jr.edu.mapper.SubjectMapper;
import cn.jr.edu.service.ISubjectService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author JR
 * @since 2022-03-02
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

    @Override
    public void readSubject(MultipartFile file,ISubjectService subjectService) {
        try{
            //获取文件输入流
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubjectData.class,new ExcelSubjectListen(subjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
            throw new GuliException(20001,"添加课程分类失败");
        }

    }
}
