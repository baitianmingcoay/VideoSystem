package com.white.service.Impl;

import com.github.pagehelper.PageHelper;
import com.white.entry.Speaker;
import com.white.mapper.SpeakerMapper;
import com.white.service.SpeakerService;
import com.white.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {


    @Override
    public List<Speaker> selectAllSpeaker() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SpeakerMapper mapper = sqlSession.getMapper(SpeakerMapper.class);
        List<Speaker> speakerList = mapper.selectAllSpeaker();
        sqlSession.close();
        return speakerList;
    }

    @Override
    public List<Speaker> selectAllSpeaker(int page, int pageSize) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SpeakerMapper mapper = sqlSession.getMapper(SpeakerMapper.class);
        PageHelper.startPage(page,pageSize);
        List<Speaker> speakerList = mapper.selectAllSpeaker();
        sqlSession.close();
        return speakerList;
    }

    @Override
    public int saveSpeaker(Speaker speaker) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SpeakerMapper mapper = sqlSession.getMapper(SpeakerMapper.class);
        int num = mapper.saveSpeaker(speaker);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int speakerDel(int id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SpeakerMapper mapper = sqlSession.getMapper(SpeakerMapper.class);
        int num = mapper.speakerDel(id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public Speaker selectById(int id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SpeakerMapper mapper = sqlSession.getMapper(SpeakerMapper.class);
        Speaker speaker = mapper.selectById(id);
        sqlSession.close();
        return speaker;
    }

    @Override
    public int updateSpeaker(Speaker speaker) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SpeakerMapper mapper = sqlSession.getMapper(SpeakerMapper.class);
        int num = mapper.updateSpeaker(speaker);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

}
