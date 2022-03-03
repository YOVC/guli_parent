package cn.jr.edu.service.impl;

import cn.jr.ExceptionHandler.GuliException;
import cn.jr.edu.entity.Subject;
import cn.jr.edu.entity.excel.ExcelSubjectData;
import cn.jr.edu.entity.subject.OneSubject;
import cn.jr.edu.entity.subject.TwoSubject;
import cn.jr.edu.listen.ExcelSubjectListen;
import cn.jr.edu.mapper.SubjectMapper;
import cn.jr.edu.service.ISubjectService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //获取全部的一级分类
        QueryWrapper<Subject> oneQueryWrapper=new QueryWrapper<>();
        oneQueryWrapper.eq("parent_id", "0");
        List<Subject> oneSubjects = this.list(oneQueryWrapper);
        //获取全部的二级分类
        QueryWrapper<Subject> twoQueryWrapper=new QueryWrapper<>();
        twoQueryWrapper.ne("parent_id","0");
        List<Subject> twoSubjects=this.list(twoQueryWrapper);

        //创建的封装一级分类的集合
        List<OneSubject> oneFinalSubjectList=new ArrayList<>();
        //封装一级分类
        for (Subject subjectO : oneSubjects) {
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(subjectO, oneSubject);
            oneFinalSubjectList.add(oneSubject);
            //创建封装二级分类的集合
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            //封装二级分类
            for (Subject subjectT : twoSubjects) {
                if (subjectT.getParentId().equals(oneSubject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(subjectT, twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
                oneSubject.setChildren(twoFinalSubjectList);
            }
        }

        return oneFinalSubjectList;
    }
}
