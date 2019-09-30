package com.white.service;

import com.white.entry.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseList();
    List<Course> getCourseList(int page, int pageSize);
}
