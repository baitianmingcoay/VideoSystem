package com.white.service;

import com.white.entry.Video;
import com.white.entry.VideoQueryVo;

import java.util.List;

public interface VideoService {
    //过滤查询
    List<Video> getAllList(VideoQueryVo queryVo);
    //获取分页查询总条数
    int selectNum(VideoQueryVo queryV);
    //保存
    int saveVideo(Video video);

    int videoDel(Integer id);
    //批量删除
    int delBatchVideos(Integer[] ids);

    Video selectById(Integer id);

    int updateVideo(Video video);
}
