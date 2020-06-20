package com.fhlxc.shopingsystem.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fhlxc.shopingsystem.model.User;

/**
* @author Xingchao Long
* @date 2020年6月20日 下午3:55:44
* @classname SearchUser
* @description
*/

@Service("SearchUser")
public class SearchUser extends SqlOperationAdapter {
    
    @Autowired
    @Qualifier("ConnectMysql")
    protected ConnectMysql connectMysql;

    @Override
    public Object searchOne(Object ... args) {
        try (Connection connection = connectMysql.setAndGetConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery((String) args[0]);
            User user = new User();
            int i = 0;
            while (resultSet.next()) {
                user.setU_id(resultSet.getString("u_id"));
                user.setU_name(resultSet.getString("u_name"));
                user.setU_pwd(resultSet.getString("u_pwd"));
                user.setU_img(resultSet.getString("u_img"));
                user.setU_mail(resultSet.getString("u_mail"));
                user.setU_address(resultSet.getString("u_address"));
                i++;
            }
            if (i == 1) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
