package com.white.service.Impl;

import com.github.pagehelper.PageHelper;
import com.white.entry.Course;
import com.white.mapper.CourseMapper;
import com.white.service.CourseService;
import com.white.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> getCourseList() {

        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courseList = mapper.getCourseList();
        sqlSession.close();
        return courseList;
    }

    @Override
    public List<Course> getCourseList(int page, int pageSize) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        PageHelper.startPage(page,pageSize);
        List<Course> courseList = mapper.getCourseList();
        sqlSession.close();
        return courseList;
    }
}
