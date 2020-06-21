package com.fhlxc.shopingsystem.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

@Service("UserSql")
public class Usersql extends SqlOperationAdapter {
    
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
    
    @Override
    public boolean insert(Object... args) {
        try (Connection connection = connectMysql.setAndGetConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement((String) args[0]);
            User user = (User) args[1];
            preparedStatement.setString(1, user.getU_address());
            preparedStatement.setString(2, user.getU_img());
            preparedStatement.setString(3, user.getU_mail());
            preparedStatement.setString(4, user.getU_name());
            preparedStatement.setString(5, user.getU_pwd());
            preparedStatement.setString(6, user.getU_id());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }
    
}
