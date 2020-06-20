package com.fhlxc.shopingsystem.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
* @author Xingchao Long
* @date 2020年6月16日 下午10:49:48
* @classname ConnectMysql
* @description
*/

@Component("ConnectMysql")
public class ConnectMysql {

    private Connection conn;
    @Autowired
    @Qualifier("MysqlProperties")
    private MysqlProperties properties;
    
    private void setConnection() {
        try {
            Class.forName(properties.driver);
            conn = DriverManager.getConnection(properties.url, properties.name, properties.password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection setAndGetConnection() {
        setConnection();
        return conn;
    }

}
