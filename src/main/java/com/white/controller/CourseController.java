package com.white.controller;

import com.github.pagehelper.PageInfo;
import com.white.entry.Course;
import com.white.service.CourseService;
import com.white.service.Impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int pageSize, Model model) {
      List<Course> courseList = courseService.getCourseList(page, pageSize);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
      model.addAttribute("PageInfo", pageInfo);
      return "behind/courseList";
    }
}
