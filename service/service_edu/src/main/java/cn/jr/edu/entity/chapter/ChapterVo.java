package cn.jr.edu.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JR
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    /**表示小节*/
    private List<VideoVo> videoVoList=new ArrayList<>();
}
