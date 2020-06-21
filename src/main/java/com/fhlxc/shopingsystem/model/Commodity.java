package com.fhlxc.shopingsystem.model;

/**
* @author Xingchao Long
* @date 2020年6月20日 下午12:03:56
* @classname Commodity
* @description 商品实体类
*/

public class Commodity {

    private String c_id;
    private String c_name;
    private float c_price;
    private String c_address;
    private String c_description;
    private String c_img;
    
    public String getC_img() {
        return c_img;
    }

    public void setC_img(String c_img) {
        this.c_img = c_img;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public float getC_price() {
        return c_price;
    }

    public void setC_price(float c_price) {
        this.c_price = c_price;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }
    
}
