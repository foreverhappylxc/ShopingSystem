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

import com.fhlxc.shopingsystem.model.ShopingCart;

/**
* @author Xingchao Long
* @date 2020年6月21日 下午9:39:35
* @classname ShopingCartSql
* @description
*/

@Service("ShopingCartSql")
public class ShopingCartSql extends SqlOperationAdapter {

    @Autowired
    @Qualifier("ConnectMysql")
    private ConnectMysql connectMysql;
    
    @Override
    public boolean insert(Object... args) {
        try (Connection connection = connectMysql.setAndGetConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement((String) args[0]);
            ShopingCart shopingCart = (ShopingCart) args[1];
            preparedStatement.setString(1, shopingCart.getC_id());
            preparedStatement.setInt(2, shopingCart.getC_number());
            preparedStatement.setFloat(3, shopingCart.getS_price());
            preparedStatement.setString(4, shopingCart.getU_id());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<Object> searchMore(Object... args) {
        List<Object> list = new ArrayList<Object>();
        try (Connection connection = connectMysql.setAndGetConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery((String) args[0]);
            while (resultSet.next()) {
                ShopingCart shopingCart = new ShopingCart();
                shopingCart.setC_id(resultSet.getString("c_id"));
                shopingCart.setC_number(resultSet.getInt("c_number"));
                shopingCart.setS_price(resultSet.getFloat("s_price"));
                shopingCart.setU_id(resultSet.getString("u_id"));
                list.add(shopingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
