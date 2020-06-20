package com.fhlxc.shopingsystem.model;

/**
* @author Xingchao Long
* @date 2020年6月20日 下午12:17:48
* @classname ShopingCart
* @description 购物车实体类
*/

public class ShopingCart {

    private String u_id;
    private String c_id;
    private float s_price;
    private int c_number;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public float getS_price() {
        return s_price;
    }

    public void setS_price(float s_price) {
        this.s_price = s_price;
    }

    public int getC_number() {
        return c_number;
    }

    public void setC_number(int c_number) {
        this.c_number = c_number;
    }
    
}
