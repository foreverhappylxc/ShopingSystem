package com.fhlxc.shopingsystem.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fhlxc.shopingsystem.model.User;
import com.fhlxc.shopingsystem.sql.SqlOperation;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午5:27:14
* @classname RegisterController
* @description
*/

@Controller
public class RegisterController {
    
    @Autowired
    @Qualifier("UserSql")
    SqlOperation userSql;
    
    @RequestMapping("registerUser")
    @ResponseBody
    public Map<String, Object> insertUser(HttpServletRequest request, @RequestBody User user) {
        boolean success = userSql.insert("insert into user(u_address,u_img,u_mail,u_name,u_pwd,u_id) values(?,?,?,?,?,?)", user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (success) {
            map.put("msg", "注册成功");
        } else {
            map.put("msg", "注册失败, 可能原因是用户id已存在");
        }
        return map;
    }
}
