package com.fhlxc.shopingsystem.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fhlxc.shopingsystem.model.User;

/**
* @author Xingchao Long
* @date 2020年6月21日 上午10:21:16
* @classname PersonalSql
* @description
*/

@Service("PersonalSql")
public class PersonalSql extends SqlOperationAdapter {
    
    @Autowired
    @Qualifier("ConnectMysql")
    protected ConnectMysql connectMysql;
    
    @Override
    public boolean modify(Object... args) {
        try (Connection connection = connectMysql.setAndGetConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement((String) args[0]);
            User user = (User) args[1];
            preparedStatement.setString(1, user.getU_address());
            preparedStatement.setString(2, user.getU_img());
            preparedStatement.setString(3, user.getU_mail());
            preparedStatement.setString(4, user.getU_name());
            preparedStatement.setString(5, user.getU_pwd());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
