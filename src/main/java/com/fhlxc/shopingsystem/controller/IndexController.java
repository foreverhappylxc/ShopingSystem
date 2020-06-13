package com.fhlxc.shopingsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @author Xingchao Long
* @date 2020年6月13日 下午3:49:45
* @classname IndexController
* @description
*/

@Controller
public class IndexController {
    
    @RequestMapping("index.lxc")
    public ModelAndView getTest(HttpServletRequest request) {
        return new ModelAndView("HelloWorld");
    }
    
}
