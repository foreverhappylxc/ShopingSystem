package com.fhlxc.shopingsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @author Xingchao Long
* @date 2020年6月19日 上午12:42:47
* @classname CentralController
* @description
*/

@Controller
public class CentralController {

    @RequestMapping("central") 
    public ModelAndView central(HttpServletRequest request) {
        // TODO
        System.out.println("被调用");
        return new ModelAndView("view/login.jsp");
    }
    
    @RequestMapping("orderFinish") 
    public ModelAndView orderFinish(HttpServletRequest request) {
        // TODO
        return new ModelAndView("wode");
    }
    
    @RequestMapping("orderUnfinish") 
    public ModelAndView orderUnfinish(HttpServletRequest request) {
        // TODO
        return new ModelAndView("wode");
    }
    
    @RequestMapping("shopingCart") 
    public ModelAndView shopingCart(HttpServletRequest request) {
        // TODO
        return new ModelAndView("wode");
    }
    
}
