package com.myorg.controller;

import com.myorg.dao.impl.UserDaoImpl;
import com.myorg.model.User;
import com.myorg.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserDaoImpl userDao;

    @RequestMapping("")
    private ModelAndView goUserList() {
        ModelAndView mv = new ModelAndView("login");
        System.out.println(userDao.findOneByName("周42"));
        return mv;
    }

    @ResponseBody
    @RequestMapping("/submit")
    private Map<String, String> handleSubmit(HttpServletRequest httpServletRequest) {
        String userName = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
        Map<String, String> map = new HashMap<String, String>();
        User user = userService.findByName(userName);
        if(user != null) {
            if(user.getPassword() != password) {
                map.put("message", "0");
            }else {
                map.put("message", "1");
            }
        }else {
            map.put("message", "2");
        }
        return map;
    }
}
