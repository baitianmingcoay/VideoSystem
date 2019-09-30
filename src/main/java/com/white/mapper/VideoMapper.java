package com.white.mapper;

import com.white.entry.Video;
import com.white.entry.VideoQueryVo;

import java.util.List;

public interface VideoMapper {
    //展示
    List<Video> getAllList(VideoQueryVo queryVo);
    int selectNum(VideoQueryVo queryVo);
    //保存
    int saveVideo(Video video);
    int videoDel(Integer id);
    int delBatchVideos(VideoQueryVo videoQueryVo);
    //修改展示
    Video selectById(Integer id);
    int updateVideo(Video video);
}
