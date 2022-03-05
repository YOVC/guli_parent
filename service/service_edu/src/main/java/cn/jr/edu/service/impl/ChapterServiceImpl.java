package cn.jr.edu.service.impl;

import cn.jr.edu.entity.Chapter;
import cn.jr.edu.entity.Video;
import cn.jr.edu.entity.chapter.ChapterVo;
import cn.jr.edu.entity.chapter.VideoVo;
import cn.jr.edu.mapper.ChapterMapper;
import cn.jr.edu.service.IChapterService;
import cn.jr.edu.service.IVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements IChapterService {

    @Autowired
    private IVideoService videoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        //获取章节
        QueryWrapper<Chapter> chapterQueryWrapper=new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id",courseId);
        List<Chapter> chapters = this.list(chapterQueryWrapper);

        //获取小节
        QueryWrapper<Video> videoQueryWrapper=new QueryWrapper<>();
        videoQueryWrapper.eq("course_id",courseId);
        List<Video> videos = videoService.list(videoQueryWrapper);

        //封装章节
        List<ChapterVo> chapterVos=new ArrayList<>();
        for (Chapter chapter:chapters){
            ChapterVo chapterVo=new ChapterVo();
            BeanUtils.copyProperties(chapter,chapterVo);
            chapterVos.add(chapterVo);
            List<VideoVo> videoVos=new ArrayList<>();
            for (Video video:videos){
                if(video.getChapterId().equals(chapter.getId())){
                    VideoVo videoVo=new VideoVo();
                    BeanUtils.copyProperties(video,videoVo);
                    videoVos.add(videoVo);
                }
            }
            chapterVo.setVideoVoList(videoVos);
        }
        return chapterVos;
    }
}
