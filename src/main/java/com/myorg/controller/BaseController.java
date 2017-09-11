package com.myorg.controller;

import com.myorg.model.User;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    //获取session中的用户
    public User getSessionUser(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if(user != null) {
            return (User) user;
        }else {
            return null;
        }
    }
}
