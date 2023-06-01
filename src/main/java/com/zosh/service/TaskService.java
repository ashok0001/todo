package com.zosh.service;

import java.util.List;

import com.zosh.modal.Task;
import com.zosh.modal.User;

public interface TaskService {
	
	public Task createTask(Task task,User user);
	
	public List<Task> findTaskByStatus(String status);
	
	public List<Task> findTodaysTask(String status);
	
	public List<Task> getAllTask();

}
