package cn.jr.edu.service.impl;

import cn.jr.edu.entity.Video;
import cn.jr.edu.mapper.VideoMapper;
import cn.jr.edu.service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author JR
 * @since 2022-03-04
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

}
