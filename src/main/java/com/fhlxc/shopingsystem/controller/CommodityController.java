package com.fhlxc.shopingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fhlxc.shopingsystem.sql.CommoditySql;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午8:25:13
* @classname CommodityController
* @description
*/

@Controller
public class CommodityController {

    @Autowired
    @Qualifier("CommoditySql")
    private CommoditySql commoditySql;
    
    @RequestMapping("search")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response,
            String search) {
        List<Object> list = commoditySql.searchMore("select * from commodity where concat_ws(';',c_address,"
                + "c_description,c_id,c_name,c_price) like '%" + search + "%'");
        return new ModelAndView("index", "list", list);
    }
    
    @RequestMapping("indexSearch")
    public ModelAndView indexSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Object> list = commoditySql.searchMore("select * from commodity where concat_ws(';',c_address,"
                + "c_description,c_id,c_name,c_price) like '%" + "%'");
        return new ModelAndView("index", "list", list);
    }
    
}
