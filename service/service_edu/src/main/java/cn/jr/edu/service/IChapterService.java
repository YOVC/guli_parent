package cn.jr.edu.service;

import cn.jr.edu.entity.Chapter;
import cn.jr.edu.entity.chapter.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
public interface IChapterService extends IService<Chapter> {
    /**
     * 通过课程id获取课程章节
     * @param courseId 课程id
     * @return 章节
     */
    List<ChapterVo> getChapterVideoByCourseId(String courseId);
}
