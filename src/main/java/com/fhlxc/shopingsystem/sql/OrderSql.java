package com.fhlxc.shopingsystem.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fhlxc.shopingsystem.model.Order;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午9:40:34
* @classname OrderSql
* @description
*/

@Service("OrderSql")
public class OrderSql extends SqlOperationAdapter {

    @Autowired
    @Qualifier("ConnectMysql")
    private ConnectMysql connectMysql;
    
    @Override
    public Object searchOne(Object... args) {
        return super.searchOne(args);
    }
    
    @Override
    public List<Object> searchMore(Object... args) {
        List<Object> list = new ArrayList<Object>();
        try (Connection connection = connectMysql.setAndGetConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery((String) args[0]);
            while (resultSet.next()) {
                Order order = new Order();
                order.setC_id(resultSet.getString("c_id"));
                order.setO_finish(resultSet.getInt("o_finish"));
                order.setO_number(resultSet.getInt("o_number"));
                order.setO_price(resultSet.getFloat("o_price"));
                String[] strings = resultSet.getString("o_receiving_address").split(";");
                String s = "";
                if (strings.length < 1) {
                    s = strings[0];
                } else {
                    s = strings[1];
                }
                order.setO_receiving_address(s);
                order.setO_shipping_address(resultSet.getString("o_shipping_address"));
                order.setO_time(resultSet.getString("o_time"));
                order.setU_id(resultSet.getString("u_id"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public boolean insert(Object... args) {
        try (Connection connection = connectMysql.setAndGetConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement((String) args[0]);
            Order order = (Order) args[1];
            preparedStatement.setString(1, order.getC_id());
            preparedStatement.setInt(2, order.getO_finish());
            preparedStatement.setInt(3, order.getO_number());
            preparedStatement.setFloat(4, order.getO_price());
            preparedStatement.setString(5, order.getO_receiving_address());
            preparedStatement.setString(6, order.getO_shipping_address());
            preparedStatement.setString(7, order.getO_time());
            preparedStatement.setString(8, order.getU_id());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
