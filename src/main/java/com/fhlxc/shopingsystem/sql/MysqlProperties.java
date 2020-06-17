package com.fhlxc.shopingsystem.sql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
* @author Xingchao Long
* @date 2020年6月16日 下午10:45:01
* @classname MysqlProperties
* @description 数据库属性文件
*/

@PropertySource("classpath:database.properties")
@Component("MysqlProperties")
@Configuration
public class MysqlProperties {

    @Value("${driver}")
    public String driver;
    @Value("${url}")
    public String url;
    @Value("${name}")
    public String name;
    @Value("${password}")
    public String password;
    /*
    @Bean("MysqlProperties")
    public MysqlProperties getBean() {
        return new MysqlProperties();
    }
    */
    
}
