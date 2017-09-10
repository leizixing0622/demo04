package com.myorg.controller;

import com.myorg.dao.impl.UserDaoImpl;
import com.myorg.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("")
    public ModelAndView goIndex () {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
