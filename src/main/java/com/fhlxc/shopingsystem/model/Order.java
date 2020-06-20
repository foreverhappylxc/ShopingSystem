package com.fhlxc.shopingsystem.model;

/**
* @author Xingchao Long
* @date 2020年6月20日 下午12:10:33
* @classname Order
* @description 订单的实体类
*/

public class Order {

    private String u_id;
    private String c_id;
    private String o_time;
    private float o_price;
    private int o_number;
    private String o_shipping_address;
    private String o_receiving_address;
    private int o_finish;
    
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

    public String getO_time() {
        return o_time;
    }

    public void setO_time(String o_time) {
        this.o_time = o_time;
    }

    public float getO_price() {
        return o_price;
    }

    public void setO_price(float o_price) {
        this.o_price = o_price;
    }

    public int getO_number() {
        return o_number;
    }

    public void setO_number(int o_number) {
        this.o_number = o_number;
    }

    public String getO_shipping_address() {
        return o_shipping_address;
    }

    public void setO_shipping_address(String o_shipping_address) {
        this.o_shipping_address = o_shipping_address;
    }

    public String getO_receiving_address() {
        return o_receiving_address;
    }

    public void setO_receiving_address(String o_receiving_address) {
        this.o_receiving_address = o_receiving_address;
    }

    public int getO_finish() {
        return o_finish;
    }

    public void setO_finish(int o_finish) {
        this.o_finish = o_finish;
    }
    
}
