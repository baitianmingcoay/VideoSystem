package com.white.controller;

import com.github.pagehelper.PageInfo;
import com.white.entry.Course;
import com.white.entry.Speaker;
import com.white.service.CourseService;
import com.white.service.Impl.CourseServiceImpl;
import com.white.service.Impl.SpeakerServiceImpl;
import com.white.service.SpeakerService;
import com.white.utils.InfoUtils;
import com.white.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
   @Autowired
   SpeakerService speakerService;
   @Autowired
   CourseService courseService;

    @RequestMapping("/list")
    public String showList(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int pageSize) {
        /*Video video = new Video();
        queryVo.setBegin((queryVo.getPage() - 1) * queryVo.getRows());
        Page<Speaker> page = new Page<Speaker>();
        page.setTotal(10);
        page.setPage(queryVo.getPage());
        page.setSize(queryVo.getRows());
        page.setRows(speakers);
        model.addAttribute("page", page);
        */

        List<Speaker> speakers = speakerService.selectAllSpeaker(page, pageSize);
        PageInfo<Speaker> pageInfo = new PageInfo<>(speakers);
        model.addAttribute("PageInfo", pageInfo);
        return "behind/speakerList";
    }
    @RequestMapping("/addspeaker")
    public String addspeaker(Model model) {
        return "behind/addSpeaker";

    }

    //头像
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

    @RequestMapping("/saveSpeaker")
    @ResponseBody
    public String saveSpeaker(Speaker speaker) {
        int num = 0;
        if (speaker.getId() != 0) {
            num = speakerService.updateSpeaker(speaker);
        } else {
            num = speakerService.saveSpeaker(speaker);
        }
        if ( num > 0) {
            return "success";
        } else {
            return "error";
        }

    }

    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(int id) {
    int num = speakerService.speakerDel(id);
    if (num > 0) {
        return "success";
    } else {
        return "error";
    }
    }


    @RequestMapping("/speakerEdit/{id}")
    public String speakerEdit(@PathVariable("id") int id, Model model) {

        Speaker speaker = speakerService.selectById(id);
        model.addAttribute("speaker",speaker);

        return "behind/addSpeaker";
    }

}
