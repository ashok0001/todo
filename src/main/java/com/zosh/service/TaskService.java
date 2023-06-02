package com.zosh.service;

import java.util.List;

import com.zosh.exceptions.TaskException;
import com.zosh.modal.Task;
import com.zosh.modal.User;

public interface TaskService {
	
	public Task createTask(Task task,User user);
	
	public List<Task> findTaskByStatus(String status);
	
	public List<Task> findTodaysTask(String status);
	
	public List<Task> getAllTask(String status, String priority, boolean today);
	
	public Task updateTaskStatus(Integer taskId,User user) throws TaskException;
	
	public Task findTaskById(Integer taskId) throws TaskException;
	
	public String deleteTaskById(Integer taskId, User user)throws TaskException;

}
