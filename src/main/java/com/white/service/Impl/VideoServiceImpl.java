package com.white.service.Impl;

import com.white.entry.Video;
import com.white.entry.VideoQueryVo;
import com.white.mapper.AdminMapper;
import com.white.mapper.VideoMapper;
import com.white.service.VideoService;
import com.white.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.List;

public class VideoServiceImpl implements VideoService {
    @Override
    public List<Video> getAllList(VideoQueryVo queryVo) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        List<Video> list = mapper.getAllList(queryVo);
        sqlSession.close();
        return list;
    }

    @Override
    public int selectNum(VideoQueryVo queryV) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        int num = mapper.selectNum(queryV);
        sqlSession.close();
        return num;
    }

    @Override
    public int saveVideo(Video video) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        int num = mapper.saveVideo(video);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int videoDel(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        int num = mapper.videoDel(id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int delBatchVideos(Integer[] ids) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        VideoQueryVo videoQueryVo = new VideoQueryVo();
        videoQueryVo.setIds(Arrays.asList(ids));
        int num = mapper.delBatchVideos(videoQueryVo);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public Video selectById(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        Video video = mapper.selectById(id);
        sqlSession.close();
        return video;
    }

    @Override
    public int updateVideo(Video video) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        System.out.println(video);
        int num = mapper.updateVideo(video);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
