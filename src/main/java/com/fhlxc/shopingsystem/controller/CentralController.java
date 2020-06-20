package com.fhlxc.shopingsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("personal") 
    public ModelAndView central(HttpServletRequest request, Model model) {
        return new ModelAndView("personal");
    }
    
    @RequestMapping("orderFinish") 
    public ModelAndView orderFinish(HttpServletRequest request) {
        // TODO
        return new ModelAndView("order_finish");
    }
    
    @RequestMapping("orderUnfinish") 
    public ModelAndView orderUnfinish(HttpServletRequest request) {
        // TODO
        return new ModelAndView("order_unfinish");
    }
    
    @RequestMapping("shopingCart") 
    public ModelAndView shopingCart(HttpServletRequest request) {
        // TODO
        return new ModelAndView("shoping_cart");
    }
    
}
