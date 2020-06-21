package com.fhlxc.shopingsystem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fhlxc.shopingsystem.model.User;
import com.fhlxc.shopingsystem.sql.SqlOperation;

/**
* @author Xingchao Long
* @date 2020年6月21日 上午8:44:52
* @classname PersonalController
* @description
*/

@Controller
public class PersonalController {

    @Autowired
    @Qualifier("PersonalSql")
    SqlOperation personalSql;
    
    @RequestMapping("pictureUpload")
    @ResponseBody
    public String pictureUpload(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)request;
        MultipartFile file = mreq.getFile("file");
        User user = (User) request.getSession().getAttribute("user");
        String fileName = file.getOriginalFilename();
        String u_id = user.getU_id();
        String name =  u_id + fileName.substring(fileName.lastIndexOf('.'));
        String path = request.getSession().getServletContext().getRealPath("/");
        File f = new File(path + "user_img");
        user.setU_img("user_img/" + name);
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().split("\\.")[0].equals(u_id)) {
                files[i].delete();
            }
        }
        FileOutputStream fos = new FileOutputStream(path + "user_img/" + name);
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
        request.getSession().setAttribute("user", user);
        personalSql.modify("update user set u_address=?, u_img=?, u_mail=?, u_name=?, u_pwd=? where u_id='" + user.getU_id() + "'", user);
        return "user_img/" + name;
    }
    
    @RequestMapping("infoModify")
    @ResponseBody
    public void infoModify(HttpServletRequest request, @RequestBody User user) {
        request.getSession().setAttribute("user", user);
        personalSql.modify("update user set u_address=?, u_img=?, u_mail=?, u_name=?, u_pwd=? where u_id='" + user.getU_id() + "'", user);
        //System.out.println(user.getU_name());
    }
    
}
