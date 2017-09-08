package com.myorg.controller;

import com.myorg.dao.impl.HouseDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private HouseDaoImpl houseDao;

    @RequestMapping(value="/2")
    public ModelAndView printWelcome () {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("houses", houseDao.findAll());
        return modelAndView;
    }
}
