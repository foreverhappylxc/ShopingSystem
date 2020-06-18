package com.fhlxc.shopingsystem.intercepter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
* @author Xingchao Long
* @date 2020年6月18日 上午12:47:41
* @classname LoginIntercepter
* @description
*/

public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.indexOf("/login") <= 0) {
            HttpSession session = request.getSession();
            Object object = session.getAttribute("user");
            if (object != null) {
                return true;
            } else {
                response.sendRedirect("loginIntercepter");
                System.out.println(object);
                return false;
            }
        } else {
            return true;
        }
    }
    
}
