package cn.jr.edu.controller;


import cn.jr.R;
import cn.jr.edu.entity.Teacher;
import cn.jr.edu.service.ITeacherService;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author JR
 * @since 2022-02-27
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    //查询所有讲师列表
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<Teacher> teachers = teacherService.list(null);
        return R.ok().data("items",teachers);
    }

    //根据id逻辑删除讲师
    @DeleteMapping("delete/{id}")
    public R deleteTeacher(@PathVariable(name = "id") String id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //分页查询
    //current为当前页，limit为每页记录数
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageTeacher(@PathVariable(value = "current") Long current,@PathVariable(value = "limit") Long limit){
        //创建page对象
        Page<Teacher> teacherPage=new Page<>(current,limit);
        //调用方法实现分页，底层封装，把分页的所有数据封装到teacherPage对象中
        teacherService.page(teacherPage,null);
        long total=teacherPage.getTotal();//获得总记录数
        List<Teacher> teachers = teacherPage.getRecords();//获得分页查询到的数据
        return R.ok().data("total",total).data("rows",teachers);
    }


}

