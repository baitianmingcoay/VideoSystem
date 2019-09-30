package com.white.controller;

import com.white.entry.Course;
import com.white.entry.Speaker;
import com.white.entry.Video;
import com.white.entry.VideoQueryVo;
import com.white.service.CourseService;
import com.white.service.Impl.CourseServiceImpl;
import com.white.service.Impl.SpeakerServiceImpl;
import com.white.service.Impl.VideoServiceImpl;
import com.white.service.SpeakerService;
import com.white.service.VideoService;
import com.white.utils.InfoUtils;
import com.white.utils.Page;
import com.white.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    SpeakerService speakerService;
    @Autowired
    CourseService courseService;
    @Autowired
    VideoService videoService;

    @RequestMapping("/list")
    public String showList(VideoQueryVo queryVo, Model model) {
            Video video = new Video();
            queryVo.setBegin((queryVo.getPage() - 1) * queryVo.getRows());
            List<Video> list = videoService.getAllList(queryVo);

            Page<Video> page = new Page<Video>();
            page.setTotal(videoService.selectNum(queryVo));
            page.setPage(queryVo.getPage());
            page.setSize(queryVo.getRows());
            page.setRows(list);
            model.addAttribute("page", page);

            List<Speaker> speakers = speakerService.selectAllSpeaker();
            model.addAttribute("speakerList", speakers);

            List<Course> courseList = courseService.getCourseList();
            model.addAttribute("courseList", courseList);
            return "behind/videoList";

    }

    @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakers);

        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("courseList", courseList);
        return "behind/addVideo";
    }

    //保存
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(Video video) {
        int reslut = 0;
        if (video.getId() == 0) {
            reslut = videoService.saveVideo(video);
        } else  {
            reslut = videoService.updateVideo(video);
        }

        if (reslut > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(Integer[]  ids){
        int result = videoService.delBatchVideos(ids);
        return "redirect:/video/list";
    }

    //图片上传展示
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile headImg) {
        String oldName = headImg.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));

        String newFileName = UUIDUtils.getUUID() + suffix;

        try {
            headImg.transferTo(new File(InfoUtils.getProperties("IMG_PATH"), newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgUrl = InfoUtils.getProperties("IMG_URL") + newFileName;
        return imgUrl;
    }



    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(Integer id) {
       int rulset = videoService.videoDel(id);
       if (rulset > 0) {
           return "success";
       } else {
           return "error";
       }
    }

    @RequestMapping("/edit/{id}")
    public String  edit(@PathVariable("id") Integer id, Model model) {
        Video video = videoService.selectById(id);
        model.addAttribute("video", video);

        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakers);

        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("courseList", courseList);
        return "behind/addVideo";
    }
}
