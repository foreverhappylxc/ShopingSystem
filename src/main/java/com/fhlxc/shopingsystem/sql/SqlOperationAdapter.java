package com.fhlxc.shopingsystem.sql;

import java.util.List;

/**
* @author Xingchao Long
* @date 2020年6月20日 下午3:54:32
* @classname SqlOperationAdapter
* @description
*/

public class SqlOperationAdapter implements SqlOperation {
    
    @Override
    public Object searchOne(Object... args) {
        return null;
    }

    @Override
    public boolean insert(Object... args) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public boolean modify(Object... args) {
        return false;
    }

    @Override
    public List<Object> searchMore(Object... args) {
        return null;
    }

}
