package com.fhlxc.shopingsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fhlxc.shopingsystem.model.ShopingCart;
import com.fhlxc.shopingsystem.model.User;
import com.fhlxc.shopingsystem.sql.CommoditySql;
import com.fhlxc.shopingsystem.sql.ShopingCartSql;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午10:10:21
* @classname ShopingCartController
* @description
*/

@Controller
public class ShopingCartController {

    @Autowired
    @Qualifier("ShopingCartSql")
    private ShopingCartSql shopingCartSql;
    @Autowired
    @Qualifier("CommoditySql")
    private CommoditySql commoditySql;
    
    @RequestMapping("addCommodity")
    @ResponseBody
    public Map<String, Object> addCommodity(HttpServletRequest request, HttpServletResponse response,
            @RequestBody ShopingCart shopingCart) {
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = "";
        boolean success = shopingCartSql.insert("insert into shoping_cart(c_id, c_number, s_price, u_id) values(?,?,?,?)", shopingCart);
        if (success) {
            msg = "添加成功";
        } else {
            msg = "添加失败，可能商品已经移除或者已经添加";
        }
        map.put("msg", msg);
        return map;
    }
    
    @RequestMapping("searchCart")
    public ModelAndView searchCart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<Object> list = shopingCartSql.searchMore("select * from shoping_cart where u_id='" + user.getU_id() + "'");
        return new ModelAndView("shoping_cart", "list", list);
    }
    
}
