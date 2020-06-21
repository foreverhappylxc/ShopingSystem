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

import com.fhlxc.shopingsystem.model.Order;
import com.fhlxc.shopingsystem.model.User;
import com.fhlxc.shopingsystem.sql.OrderSql;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午11:35:26
* @classname OrderController
* @description
*/

@Controller
public class OrderController {

    @Autowired
    @Qualifier("OrderSql")
    private OrderSql orderSql;
    
    @RequestMapping("addOrder") 
    @ResponseBody
    public Map<String, Object> addOrder(HttpServletRequest request, HttpServletResponse response, 
            @RequestBody Order order) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean success = orderSql.insert("insert into `order`(c_id,o_finish,o_number,o_price,o_receiving_address,"
                + "o_shipping_address,o_time,u_id) values(?,?,?,?,?,?,?,?)", order);
        if (success) {
            map.put("msg", "添加成功");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }
    
    @RequestMapping("searchOrder") 
    @ResponseBody
    public ModelAndView searchOrder(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<Object> list = orderSql.searchMore("select * from `order` where u_id=" + user.getU_id());
        return new ModelAndView("order_finish", "list", list);
    }
    
}
