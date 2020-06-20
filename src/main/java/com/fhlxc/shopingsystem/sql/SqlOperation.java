package com.fhlxc.shopingsystem.sql;

import java.util.List;

/**
* @author Xingchao Long
* @date 2020年6月20日 下午2:20:09
* @classname SqlOperation
* @description 定义数据库操作的接口
*/

public interface SqlOperation {

    public Object searchOne(Object ... args);
    public boolean insert(Object ... args);
    public boolean delete(Object ... args);
    public boolean modify(Object ... args);
    public List<Object> searchMore(Object ... args);
    
}
