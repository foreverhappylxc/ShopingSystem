package com.fhlxc.shopingsystem.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fhlxc.shopingsystem.model.Commodity;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午7:15:45
* @classname CommoditySql
* @description
*/

@Service("CommoditySql")
public class CommoditySql extends SqlOperationAdapter {

    @Autowired
    @Qualifier("ConnectMysql")
    private ConnectMysql connectMysql;
    
    @Override
    public List<Object> searchMore(Object... args) {
        List<Object> list = new ArrayList<Object>();
        try (Connection connection = connectMysql.setAndGetConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery((String) args[0]);
            while (resultSet.next()) {
                Commodity commodity = new Commodity();
                commodity.setC_address(resultSet.getString("c_address"));
                commodity.setC_description(resultSet.getString("c_description"));
                commodity.setC_id(resultSet.getString("c_id"));
                commodity.setC_name(resultSet.getString("c_name"));
                commodity.setC_price(resultSet.getFloat("c_price"));
                commodity.setC_img(resultSet.getString("c_img"));
                list.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public Object searchOne(Object... args) {
        Commodity commodity = null;
        try (Connection connection = connectMysql.setAndGetConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery((String) args[0]);
            while (resultSet.next()) {
                commodity = new Commodity();
                commodity.setC_address(resultSet.getString("c_address"));
                commodity.setC_description(resultSet.getString("c_description"));
                commodity.setC_id(resultSet.getString("c_id"));
                commodity.setC_name(resultSet.getString("c_name"));
                commodity.setC_price(resultSet.getFloat("c_price"));
                commodity.setC_img(resultSet.getString("c_img"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }
    
}
