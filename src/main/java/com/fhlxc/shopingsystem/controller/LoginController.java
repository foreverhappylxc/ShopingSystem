package com.fhlxc.shopingsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fhlxc.shopingsystem.model.User;
import com.fhlxc.shopingsystem.sql.SqlOperation;

/**
* @author Xingchao Long
* @date 2020年6月13日 下午3:49:45
* @classname IndexController
* @description
*/

@SessionAttributes({"user"})
@Controller
public class LoginController {

    @Autowired
    @Qualifier("SearchUser")
    SqlOperation sqlOperation;
    
    @RequestMapping("handle_login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model
            , String id, String pwd, RedirectAttributes attributes) {
        User user = (User)sqlOperation.searchOne("select * from user where u_id=" + id);
        if (user == null) {
            attributes.addAttribute("error", "账户名或者密码错误！");
            return new ModelAndView("redirect:login");
        }
        if (pwd.equals(user.getU_pwd())) {
            model.addAttribute("user", user);
            return new ModelAndView("redirect:index");
        } else {
            attributes.addAttribute("error", "账户名或者密码错误！");
            return new ModelAndView("redirect:login");
        }
    }
    
    @RequestMapping("login")
    public ModelAndView loginIntercepter(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }
    
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }
    
}
