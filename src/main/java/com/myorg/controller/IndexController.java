package com.myorg.controller;

import com.myorg.dao.impl.UserDaoImpl;
import com.myorg.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    @RequestMapping("")
    public ModelAndView goIndex (HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("index");
        HttpSession session = httpServletRequest.getSession();
        if(getSessionUser(httpServletRequest) != null) {
            mv.addObject("username", getSessionUser(httpServletRequest).getName());
        }
        return mv;
    }
}
