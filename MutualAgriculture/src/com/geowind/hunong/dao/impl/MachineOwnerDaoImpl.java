package com.geowind.hunong.dao.impl;


import java.util.List;

import com.geowind.hunong.entities.Machineowner;
import com.geowind.hunong.dao.MachineOwnerDao;
import com.geowind.hunong.util.DBHelper;

/**
 * Created by Kui on 2016/9/3.
 */
public class MachineOwnerDaoImpl implements MachineOwnerDao {


    @Override
    public int insertMachineOwner(Machineowner machineOwner) {
        String sql = "insert into machineowner values(null, ?, ?, ?)";
        return DBHelper.doUpdate(sql, machineOwner.getPhone(), machineOwner.getName(), machineOwner.getAddress());
    }
    
    @Override
    public List<Machineowner> search(Machineowner searchMachineowner) {
    	// TODO Auto-generated method stub
    	return null;
    }
}
