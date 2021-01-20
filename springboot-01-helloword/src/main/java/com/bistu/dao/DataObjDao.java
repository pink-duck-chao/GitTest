package com.bistu.dao;

import com.bistu.pojo.DataObj;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DataObjDao {

    private static Map<Integer, DataObj> employees = new HashMap<Integer, DataObj>();

    private static Integer initId = 1000;
    //增加一个员工
    public void save(DataObj dataObj){

        employees.put(initId++,dataObj);
    }

    public Collection<DataObj> getAll(){
        return employees.values();
    }


}
