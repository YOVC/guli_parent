package cn.jr.edu.listen;

import cn.jr.ExceptionHandler.GuliException;
import cn.jr.edu.entity.Subject;
import cn.jr.edu.entity.excel.ExcelSubjectData;
import cn.jr.edu.service.ISubjectService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

public class ExcelSubjectListen extends AnalysisEventListener<ExcelSubjectData> {

    public ISubjectService subjectService;
    public ExcelSubjectListen(){}
    public ExcelSubjectListen(ISubjectService subjectService){
        this.subjectService=subjectService;
    }
    @Override
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {
        if(null==excelSubjectData){
            throw new GuliException(20001,"excel表格为空");
        }

        //添加一级分类
        Subject OneSubject=this.existOneSubjectName(subjectService,excelSubjectData.getOneSubjectName());

        if(null==OneSubject){
            OneSubject=new Subject();
            OneSubject.setTitle(excelSubjectData.getOneSubjectName());
            OneSubject.setParentId("0");
            subjectService.save(OneSubject);
        }

        //添加获取一级分类id值
        String pid =OneSubject.getId();

        //添加二级分类
        Subject twoSubject=this.existTwoSubjectName(subjectService,excelSubjectData.getTwoSubjectName(), pid);
        if(null==twoSubject){
            twoSubject=new Subject();
            twoSubject.setTitle(excelSubjectData.getTwoSubjectName());
            twoSubject.setParentId(pid);
            subjectService.save(twoSubject);
        }

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息"+headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    /**判断一级分类是否重复*/
    public Subject existOneSubjectName(ISubjectService subjectService,String name){
        QueryWrapper<Subject> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        Subject subject = subjectService.getOne(queryWrapper);
        return subject;
    }

    /**判断额吉分类是否重复*/
    public  Subject existTwoSubjectName(ISubjectService subjectService,String name,String parentId){
       QueryWrapper<Subject> queryWrapper= new QueryWrapper<>();
       queryWrapper.eq("title",name);
       queryWrapper.eq("parent_id",parentId);
       Subject subject = subjectService.getOne(queryWrapper);
       return subject;
    }
}
