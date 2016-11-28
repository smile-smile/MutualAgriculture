package com.geowind.hunong.service.impl;

import com.geowind.hunong.dao.TaskDao;
import com.geowind.hunong.dao.impl.TaskDaoImpl;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.FarmlandDAO;
import com.geowind.hunong.jpa.MachineDAO;
import com.geowind.hunong.jpa.Task;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kui on 2016/7/21.
 */
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    public TaskServiceImpl() {
    	taskDao = new TaskDaoImpl();
    }

	@Override
	public List<Task> getTaskInfo(int centerId, int isFinished) {
		List<Map<String, Object>> maps = taskDao.getTaskInfo(centerId, isFinished);
		List<Task> list = new ArrayList<Task>();
		for(Map<String, Object> map : maps) {
			Task task = new Task();
			task.setTaskId((int)map.get("taskid"));
			task.setUser(new UserDAO().findById((String)map.get("username")));
			task.setFarmland(new FarmlandDAO().findById((int)map.get("farmlandid")));
			task.setWorkload((int)map.get("workload"));
			task.setMachine(new MachineDAO().findById((int)map.get("machineid")));
			task.setPublishdate((String)map.get("publishdate"));
			task.setWorkdate((String)map.get("workdate"));
			task.setType((String)map.get("type"));
			task.setDesrc((String)map.get("descr"));
			task.setCenter(new CenterDAO().findById((int)map.get("centerid")));
			task.setFinished((int)map.get("finished"));
			list.add(task);
		}
		return list;
	}

	@Override
	public List<Task> historyTaskByUser(int centerId, int isFinished,
			String username) {
		List<Map<String, Object>> maps = taskDao.historyTaskByUser(centerId, isFinished, username);
		List<Task> list = new ArrayList<Task>();
		for(Map<String, Object> map : maps) {
			Task task = new Task();
			task.setTaskId((int)map.get("taskid"));
			task.setUser(new UserDAO().findById((String)map.get("username")));
			task.setFarmland(new FarmlandDAO().findById((int)map.get("farmlandid")));
			task.setWorkload((int)map.get("workload"));
			task.setMachine(new MachineDAO().findById((int)map.get("machineid")));
			task.setPublishdate((String)map.get("publishdate"));
			task.setWorkdate((String)map.get("workdate"));
			task.setType((String)map.get("type"));
			task.setDesrc((String)map.get("descr"));
			task.setCenter(new CenterDAO().findById((int)map.get("centerid")));
			task.setFinished((int)map.get("finished"));
			list.add(task);
		}
		return list;
	}




}
