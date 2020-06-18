package com.fhlxc.shopingsystem.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fhlxc.shopingsystem.sql.ConnectMysql;

/**
* @author Xingchao Long
* @date 2020年6月13日 下午3:49:45
* @classname IndexController
* @description
*/

@Controller
public class LoginController {
    
    @Autowired
    @Qualifier("ConnectMysql")
    private ConnectMysql connectMysql;
    
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request) {
        // TODO 
        connectMysql.setConnection();
        Connection connection = connectMysql.getConnection();
        if (connection != null) {
            System.out.println("连接成功！");
        }
        return new ModelAndView("view/index.jsp");
    }
    
    @RequestMapping("loginIntercepter")
    public ModelAndView loginIntercepter(HttpServletRequest request) {
        return new ModelAndView("view/login.jsp");
    }
    
}
