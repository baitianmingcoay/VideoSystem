package com.white.controller;

import com.white.service.AdminService;
import com.white.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/showLogin")
    public String showLogin(){
        return "behind/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
    if(adminService.isLogin(username,password)) {
        session.setAttribute("USERNAME", username);
        return "success";
    }
    return "error";
    }
}
